package piechart3d;
/* ===================
 * Orson Charts - Demo
 * ===================
 * 
 * Copyright (c) 2013-2017, Object Refinery Limited.
 * All rights reserved.
 *
 * http://www.object-refinery.com/orsoncharts/index.html
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *   - Neither the name of the Object Refinery Limited nor the
 *     names of its contributors may be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL OBJECT REFINERY LIMITED BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * Note that the above terms apply to the demo source only, and not the 
 * Orson Charts library.
 * 
 */



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.TitleAnchor;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.data.StandardPieDataset3D;
import com.orsoncharts.plot.PiePlot3D;

import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.label.StandardPieLabelGenerator;
import static com.orsoncharts.label.StandardPieLabelGenerator.PERCENT_TEMPLATE;

/**
 * A demo of a pie chart.
 */
@SuppressWarnings("serial")
public class PieChart3DDemo2 extends JPanel {
    
    /**
     * Returns a panel containing the content for the demo.  This method is
     * used across all the individual demo applications to allow aggregation 
     * into a single "umbrella" demo (OrsonChartsDemo).
     * 
     * @return A panel containing the content for the demo.
     */
    public static JPanel createDemoPanel(String[] sName, double [] dMoney) {
        DemoPanel content = new DemoPanel(new BorderLayout());
        //content.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        content.setPreferredSize(new Dimension(410, 350));
        PieDataset3D<String> dataset = createDataset(sName, dMoney);
        final Chart3D chart = createChart(dataset);
        Chart3DPanel chartPanel = new Chart3DPanel(chart);
        chartPanel.setMargin(0.15);
        content.setChartPanel(chartPanel);
        //chartPanel.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        content.add(new DisplayPanel3D(chartPanel));
//        JButton button = new JButton("Change the Data");
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                PieDataset3D<String> dataset = createDataset(sName, dMoney);
//                PiePlot3D plot = (PiePlot3D) chart.getPlot();
//                plot.setDataset(dataset);
//            }
//        });
//        content.add(button, BorderLayout.SOUTH);
        return content;
    }
    
        /**
     * Creates a sample dataset (hard-coded for the purpose of keeping the
     * demo self-contained - in practice you would normally read your data
     * from a file, database or other source).
     * 
     * @return A sample dataset.
     */
    private static PieDataset3D<String> createDataset(String [] sName, double [] dMoney) {
        StandardPieDataset3D<String> dataset = new StandardPieDataset3D<String>();
        for(int i = 0 ; i<sName.length ; i++) {
        	dataset.add(sName[i], dMoney[i]);
        }
//        dataset.add("United States", Math.random() * 30);
//        dataset.add("France", Math.random() * 20);
//        dataset.add("New Zealand", Math.random() * 12);
//        dataset.add("United Kingdom", Math.random() * 43);
//        dataset.add("Australia", Math.random() * 43);
//        dataset.add("Canada", Math.random() * 43);
        return dataset; 
    }
  
    /**
     * Creates a pie chart based on the supplied dataset.
     * 
     * @param dataset  the dataset.
     * 
     * @return A pie chart. 
     */
    private static Chart3D createChart(PieDataset3D<String> dataset) {
        final Chart3D chart = Chart3DFactory.createPieChart("Orson Charts 3D", 
            "For more info see: http://www.object-refinery.com/orsoncharts/", 
            dataset);
        chart.setTitleAnchor(TitleAnchor.TOP_LEFT);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLegendLabelGenerator(new StandardPieLabelGenerator(PERCENT_TEMPLATE));
        plot.setSectionLabelGenerator(new StandardPieLabelGenerator(PERCENT_TEMPLATE));
        plot.setSectionColors(Colors.createFancyLightColors());
        return chart;
    }
    
    /**
     * Creates a new test app.
     *
     * @param title  the frame title.
     */
    public PieChart3DDemo2(String title, String[] sName, double [] dMoney) {
        //super(title);
        //addWindowListener(new ExitOnClose());
        //getContentPane().add(createDemoPanel(sName , dMoney));
    	add(createDemoPanel(sName , dMoney));
    }

    /**
     * Starting point for the app.
     *
     * @param args  command line arguments (ignored).
     */
    public static void main(String[] args) {
//    	String [] sName = {"aa" , "bb"};
//    	double [] dMoney = {100 , 500};
//        PieChart3DDemo2 app = new PieChart3DDemo2(
//                "OrsonCharts: PieChart3DDemo2.java", sName , dMoney);
//        app.pack();
//        app.setVisible(true);
    }

}