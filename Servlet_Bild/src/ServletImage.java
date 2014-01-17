import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletImage")
public class ServletImage extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletImage() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg");  
  
        try  
        {  
            //Größe des Bilds festlegen (150*150)
            BufferedImage bufferedImage = new BufferedImage(150, 150,BufferedImage.TYPE_INT_RGB);  
  
            int random;
            random = (int) Math.floor((Math.random()*6)+1);
            
            Graphics graphic = bufferedImage.getGraphics();  
            
            switch (random){
            case 1: random = 1;
                            graphic.setColor(Color.cyan);
                            graphic.fillRect(0, 0, 100, 100);
                            break;
            case 2: random = 2;
                            graphic.setColor(Color.yellow);
                            graphic.fillOval(0, 0, 150, 150);
                            break;
            case 3: random = 3;
                            graphic.setColor(Color.yellow);
                            graphic.drawString("ServletImage", 40, 40);
                            break;
            case 4: random = 4;
                            graphic.setColor(Color.red);
                            graphic.drawRoundRect(0, 0, 100, 500, 20, 20);
                            break;
            case 5: random = 5;
                            graphic.setColor(Color.darkGray);
                            graphic.drawLine(20, 30, 100, 100);
                            break;
            
            case 6: random = 6;
            				graphic.setColor(Color.magenta);
            				graphic.draw3DRect(10, 10, 100, 100, true);
            				break;                
            }
            
            graphic.dispose();  
  
            ImageIO.write(bufferedImage, "jpg", response.getOutputStream()); //in JPG schreiben 
        }  
        catch (IOException ioe)  
        {  
        	//Leer
        }  
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
        }

}