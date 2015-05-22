package wine;

import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.rules.ZeroR;
import weka.core.Instances;

public class WineZeroR {
	
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader("../weka/src/main/datas/wine.arff");
		Instances instancia = new Instances(file);
		instancia.setClassIndex(0);
		ZeroR classidicador = new ZeroR();
		classidicador.buildClassifier(instancia);
		
		
		
		
		Evaluation eval = new Evaluation(instancia);
		eval.evaluateModel(classidicador, instancia);
		
		eval.crossValidateModel(classidicador, instancia, 10, new Random(1), args);
		
		  double[][] matrix = eval.confusionMatrix();
		  for(int i =0; i < matrix.length;i++){
			  for(int j =0; j < matrix.length;j++){
				  System.out.println(matrix[i][j]);
				  System.out.println("------");
			  }
		  }
		
		System.out.println(eval.numInstances());
		System.out.println(eval.avgCost());
		System.out.println(eval.correct());
		System.out.println(eval.incorrect());
		System.out.println(eval.errorRate());
		System.out.println(eval.unclassified());
		
		
		
	}
   
}
