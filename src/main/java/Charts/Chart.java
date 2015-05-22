package Charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Chart extends ApplicationFrame{
	
	public void gerarGrafico(ResultadoAvaliacao ...resultados){
		final Chart demo = new Chart("Inteligência Artificial",resultados);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
	}
	
	/**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
	
	public Chart(final String title,ResultadoAvaliacao ...resultados) {

        super(title);
        
        final CategoryDataset dataset = criarDataSet(resultados);
        final JFreeChart chart = criarChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
	
	private CategoryDataset criarDataSet(ResultadoAvaliacao ...resultado) {

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        
        for (ResultadoAvaliacao resultadoAvaliacao : resultado) {
        	
        	dataset.addValue(resultadoAvaliacao.getCustoMedio(), resultadoAvaliacao.getAlgoritmo(), "Custo Médio");   
        	dataset.addValue(resultadoAvaliacao.getTaxaDeErro(), resultadoAvaliacao.getAlgoritmo(), "Taxa de Erro");
        	dataset.addValue(resultadoAvaliacao.getValoresCorretos(), resultadoAvaliacao.getAlgoritmo(), "Número de Acertos");
        	
		}
        return dataset;

    }
	
private JFreeChart criarChart(final CategoryDataset dataset) {
        
        final JFreeChart chart = ChartFactory.createBarChart3D(
            "Gráfico Data Wine",      // chart title
            "Algoritmos",               // domain axis label
            "Valores",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        final BarRenderer r = (BarRenderer) renderer;
        //r.setMaxBarWidth(0.05);
        
        return chart;

    }
	
	

}
