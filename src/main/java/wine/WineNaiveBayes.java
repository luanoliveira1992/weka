package wine;

import java.io.FileReader;
<<<<<<< HEAD
import java.util.Random;
=======
>>>>>>> f9f4f36a77571827ca6913a86613a025e1c9d4d7

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class WineNaiveBayes {
	public static void main(String[] args) throws Exception {
<<<<<<< HEAD
		FileReader file = new FileReader("../weka/src/main/datas/wine.arff");
=======
		FileReader file = new FileReader("/home/luan/workspace/weka/weka/src/main/datas/wine.arff");
>>>>>>> f9f4f36a77571827ca6913a86613a025e1c9d4d7
		Instances instancia = new Instances(file);
		instancia.setClassIndex(0);
		NaiveBayes classidicador = new NaiveBayes();
		classidicador.buildClassifier(instancia);
		
		
		
		Evaluation eval = new Evaluation(instancia);
		eval.evaluateModel(classidicador, instancia);
<<<<<<< HEAD
		
		
=======
>>>>>>> f9f4f36a77571827ca6913a86613a025e1c9d4d7
		System.out.println(eval.numInstances());
		System.out.println(eval.avgCost());
		System.out.println(eval.correct());
		System.out.println(eval.incorrect());
		System.out.println(eval.errorRate());
		System.out.println(eval.unclassified());
	}

}
