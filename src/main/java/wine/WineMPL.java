package wine;

import java.io.FileReader;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;

public class WineMPL {
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader(
				"/home/luan/workspace/weka/weka/src/main/datas/wine.arff");
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
		eval.evaluateModel(classidicador, instancia);
		System.out.println(eval.numInstances());
		System.out.println(eval.avgCost());
		System.out.println(eval.correct());
		System.out.println(eval.incorrect());
		System.out.println(eval.errorRate());
		System.out.println(eval.unclassified());
	}
}
