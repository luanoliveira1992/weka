package wine;

import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;

public class WineMPL {
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader(
				"../weka/src/main/datas/wine.arff");
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
		eval.crossValidateModel(classidicador, instancia, 10, new Random(1), args);
		
		double[][] matrix = eval.confusionMatrix();
		  for(int i =0; i < matrix.length;i++){
			  for(int j =0; j < matrix.length;j++){
				  System.out.println(matrix[i][j]);
				  System.out.println("------");
			  }
		  }
		
		System.out.println("Valores: ");
		System.out.println(eval.numInstances());
		System.out.println(eval.avgCost());
		System.out.println(eval.correct());
		System.out.println(eval.incorrect());
		System.out.println(eval.errorRate());
		System.out.println(eval.unclassified());
	}
}
