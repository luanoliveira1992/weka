package wine;

import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.rules.ZeroR;
import weka.core.Instances;

public class WineZeroR {
	
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader("/home/rlfo/workspaceEstudos/weka/src/main/datas/breast-cancer-wisconsin.arff");
		Instances instancia = new Instances(file);
		instancia.setClassIndex(10);
		NaiveBayes classificador = new NaiveBayes();
		classificador.buildClassifier(instancia);
		
		
		
		Evaluation eval = new Evaluation(instancia);
		eval.evaluateModel(classificador, instancia);
		eval.crossValidateModel(classificador, instancia, 2, new Random(1));
		System.out.println(eval.correct());
		
		
	}
   
}
