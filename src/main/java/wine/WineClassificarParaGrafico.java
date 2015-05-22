package wine;

import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.rules.ZeroR;
import weka.core.Instances;
import Charts.Chart;
import Charts.ResultadoAvaliacao;

public class WineClassificarParaGrafico {
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader("../weka/src/main/datas/wine.arff");
		Instances instancia = new Instances(file);
		instancia.setClassIndex(0);

		MultilayerPerceptron classidicador = new MultilayerPerceptron();
		classidicador.setHiddenLayers("3");
		classidicador.setHiddenLayers("6");
		classidicador.setHiddenLayers("9");
		classidicador.setHiddenLayers("1");
		classidicador.setHiddenLayers("2");

		classidicador.buildClassifier(instancia);

		Evaluation eval = new Evaluation(instancia);
		eval.crossValidateModel(classidicador, instancia, 10, new Random(1),
				args);

		ResultadoAvaliacao resultadoMLP = new ResultadoAvaliacao(
				eval.confusionMatrix(),eval.numInstances(), eval.avgCost(), eval.correct(),
				eval.incorrect(), eval.errorRate(), eval.unclassified(),
				"Rede Neural");
		
		ZeroR classidicadorZero = new ZeroR();
		
		classidicadorZero.buildClassifier(instancia);

		Evaluation evalZeroR = new Evaluation(instancia);
		evalZeroR.crossValidateModel(classidicadorZero, instancia, 10, new Random(1),
				args);
		
		ResultadoAvaliacao resultadoZeroR = new ResultadoAvaliacao(
				evalZeroR.confusionMatrix(),evalZeroR.numInstances(), evalZeroR.avgCost(), evalZeroR.correct(),
				evalZeroR.incorrect(), evalZeroR.errorRate(), evalZeroR.unclassified(),
				"ZeroR");
		
		NaiveBayes classidicadorBayes = new NaiveBayes();
		classidicadorBayes.buildClassifier(instancia);
		
		Evaluation evalBayes = new Evaluation(instancia);
		evalZeroR.crossValidateModel(classidicadorBayes, instancia, 10, new Random(1),
				args);
		
		ResultadoAvaliacao resultadoBayes = new ResultadoAvaliacao(
				evalBayes.confusionMatrix(),evalBayes.numInstances(), evalBayes.avgCost(), evalBayes.correct(),
				evalBayes.incorrect(), evalBayes.errorRate(), evalBayes.unclassified(),
				"Naive Bayes");
		
		Chart chart = new Chart("Aplicação Teste",resultadoMLP,resultadoZeroR,resultadoBayes);
		chart.gerarGrafico();
		
	}

}
