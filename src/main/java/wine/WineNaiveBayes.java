package wine;

import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class WineNaiveBayes {
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader("../weka/src/main/datas/wine.arff");
		Instances instancia = new Instances(file);
		instancia.setClassIndex(0);
		NaiveBayes classidicador = new NaiveBayes();
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
