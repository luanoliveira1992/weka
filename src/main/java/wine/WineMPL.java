package wine;

import java.io.FileReader;
<<<<<<< HEAD
import java.util.Random;
=======
>>>>>>> f9f4f36a77571827ca6913a86613a025e1c9d4d7

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;

public class WineMPL {
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader(
<<<<<<< HEAD
				"../weka/src/main/datas/wine.arff");
		Instances instancia = new Instances(file);
		instancia.setClassIndex(0);
		
=======
				"/home/luan/workspace/weka/weka/src/main/datas/wine.arff");
		Instances instancia = new Instances(file);
		instancia.setClassIndex(0);
>>>>>>> f9f4f36a77571827ca6913a86613a025e1c9d4d7
		MultilayerPerceptron classidicador = new MultilayerPerceptron();
		classidicador.setHiddenLayers("3");
		classidicador.setHiddenLayers("6");
		classidicador.setHiddenLayers("9");
		classidicador.setHiddenLayers("1");
		classidicador.setHiddenLayers("2");
		
		
			
		classidicador.buildClassifier(instancia);

		Evaluation eval = new Evaluation(instancia);
<<<<<<< HEAD
		eval.crossValidateModel(classidicador, instancia, 10, new Random(1), args);
		
		double[][] matrix = eval.confusionMatrix();
		  for(int i =0; i < matrix.length;i++){
			  for(int j =0; j < matrix.length;j++){
				  System.out.println(matrix[i][j]);
				  System.out.println("------");
			  }
		  }
		
		System.out.println("Valores: ");
=======
		eval.evaluateModel(classidicador, instancia);
>>>>>>> f9f4f36a77571827ca6913a86613a025e1c9d4d7
		System.out.println(eval.numInstances());
		System.out.println(eval.avgCost());
		System.out.println(eval.correct());
		System.out.println(eval.incorrect());
		System.out.println(eval.errorRate());
		System.out.println(eval.unclassified());
	}
}
