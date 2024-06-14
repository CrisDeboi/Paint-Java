package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

public class Controlador {

    Modelo modelo;
    Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.controlador = this;
    }

    public static Color parseColor(String colorString) {
        // Extrae la subcadena que contiene los valores de r, g y b
        String[] parts = colorString.substring(colorString.indexOf("[") + 1, colorString.indexOf("]")).split(",");

        // Inicializa los valores de r, g y b
        int r = 0, g = 0, b = 0;

        // Recorre las partes para extraer los valores de r, g y b
        for (String part : parts) {
            String[] keyValue = part.split("=");
            String key = keyValue[0].trim();
            int value = Integer.parseInt(keyValue[1].trim());

            // Asigna el valor correspondiente a r, g o b
            switch (key) {
                case "r":
                    r = value;
                    break;
                case "g":
                    g = value;
                    break;
                case "b":
                    b = value;
                    break;
            }
        }

        // Crea y retorna un nuevo objeto Color
        return new Color(r, g, b);
    }

    public void dibujarFigurasBD(String nombreDibujo) {
        int idDibujo = Integer.parseInt(modelo.obtenerIDDibujoBD(nombreDibujo));
        int figuras = modelo.contarFiguras(idDibujo);

        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(Color.BLACK);
        int contPunto = 0;
        int contRecta = 0;
        int contCirculo = 0;
        int contPoligonoRegular = 0;
        int contPoligonoRegularRelleno = 0;
        int x1, y1, x2, y2,lados;
        

        for (int i = 0; i < figuras +1 ; i++) {
            String tipoFigura = modelo.obtenerTipoFigura(idDibujo, i);
            try {               
           
            switch (tipoFigura) {
                case "Punto":
                    String coordenadas = modelo.obtenerCoordsPunto(idDibujo, tipoFigura, contPunto);
                    String color = modelo.obtenerColorPunto(idDibujo, tipoFigura, contPunto);
                    g.setColor(parseColor(color));
                    String coordenadasIntPunto[] = coordenadas.split(",");
                    x1 = Integer.parseInt(coordenadasIntPunto[0]);
                    y1 = Integer.parseInt(coordenadasIntPunto[1]);
                    contPunto++;
                    g.fillOval(x1, y1, 10, 10);
                    break;
                case "Recta":
                    coordenadas = modelo.obtenerCoordsRecta(idDibujo, tipoFigura, contRecta);
                    color = modelo.obtenerColorRecta(idDibujo, tipoFigura, contRecta);
                    g.setColor(parseColor(color));
                    String coordenadasIntRecta[] = coordenadas.split(",");
                    x1 = Integer.parseInt(coordenadasIntRecta[0]);
                    y1 = Integer.parseInt(coordenadasIntRecta[1]);
                    x2 = Integer.parseInt(coordenadasIntRecta[2]);
                    y2 = Integer.parseInt(coordenadasIntRecta[3]);
                    contRecta++;
                    g.drawLine(x1, y1, x2, y2);
                    break;
                case "Circulo":
                    coordenadas = modelo.obtenerCoordsCirculo(idDibujo, tipoFigura, contCirculo);
                    color = modelo.obtenerColorCirculo(idDibujo, tipoFigura, contCirculo);                    
                    String coordenadasIntCirculo[] = coordenadas.split(",");
                    x1 = Integer.parseInt(coordenadasIntCirculo[0]);
                    y1 = Integer.parseInt(coordenadasIntCirculo[1]);
                    x2 = Integer.parseInt(coordenadasIntCirculo[2]);
                    y2 = Integer.parseInt(coordenadasIntCirculo[3]);
                    contCirculo++;
                    dibujarCirculoBD(x1, y1, x2, y2, parseColor(color));                    
                    break;
                case "Poligono Regular":
                    coordenadas = modelo.obtenerCoordsPoligonoRegular(idDibujo, tipoFigura, contPoligonoRegular);
                    color = modelo.obtenerColorPoligonoRegular(idDibujo, tipoFigura, contPoligonoRegular);   
                    lados= modelo.obtenerLadosPoligonoRegular(idDibujo, tipoFigura, contPoligonoRegular);
                    String coordenadasIntPoligonoRegular[] = coordenadas.split(",");
                    x1 = Integer.parseInt(coordenadasIntPoligonoRegular[0]);
                    y1 = Integer.parseInt(coordenadasIntPoligonoRegular[1]);
                    x2 = Integer.parseInt(coordenadasIntPoligonoRegular[2]);
                    y2 = Integer.parseInt(coordenadasIntPoligonoRegular[3]);
                    contPoligonoRegular++;
                    dibujarPoligonoRegularBD(x1, y1, x2, y2, lados, parseColor(color));                    
                    break;
                case "Poligono Regular Relleno":
                    coordenadas = modelo.obtenerCoordsPoligonoRegularRelleno(idDibujo, tipoFigura, contPoligonoRegularRelleno);
                    color = modelo.obtenerColorPoligonoRegular(idDibujo, tipoFigura, contPoligonoRegularRelleno);   
                    lados= modelo.obtenerLadosPoligonoRegular(idDibujo, tipoFigura, contPoligonoRegularRelleno);
                    String coordenadasIntPoligonoRegularRelleno[] = coordenadas.split(",");
                    x1 = Integer.parseInt(coordenadasIntPoligonoRegularRelleno[0]);
                    y1 = Integer.parseInt(coordenadasIntPoligonoRegularRelleno[1]);
                    x2 = Integer.parseInt(coordenadasIntPoligonoRegularRelleno[2]);
                    y2 = Integer.parseInt(coordenadasIntPoligonoRegularRelleno[3]);
                    contPoligonoRegularRelleno++;
                    dibujarPoligonoRegularRellenoBD(x1, y1, x2, y2, lados, parseColor(color));                     
                    break;
            } } catch (Exception e) {
                System.out.println("Algo pasó cargando las figuras");
            }
        }

    }

    public void dibujarPunto(int x1, int y1, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.fillOval(x1, y1, 10, 10);

        //Insertarlo en la base de datos:
        String coordenadas = String.valueOf(x1) + "," + String.valueOf(y1);
        String colorFigura = String.valueOf(color);
        modelo.insertarPunto(coordenadas, colorFigura);
    }

    public void dibujarPuntoBD(int x1, int y1, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.fillOval(x1, y1, 10, 10);
    }

    public void dibujarRecta(int x1, int y1, int x2, int y2, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);

        //Insertarlo en la base de datos:
        String coordenadas = String.valueOf(x1) + "," + String.valueOf(y1) + "," + String.valueOf(x2) + "," + String.valueOf(y2);
        String colorFigura = String.valueOf(color);
        modelo.insertarRecta(coordenadas, colorFigura);
    }

    public void dibujarRectaBD(int x1, int y1, int x2, int y2, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    public void dibujarCirculo(int x1, int y1, int x2, int y2, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);
        int radio = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        g.drawOval(x1 - radio, y1 - radio, 2 * radio, 2 * radio);

        //Insertarlo en la base de datos:
        String coordenadas = String.valueOf(x1) + "," + String.valueOf(y1) + "," + String.valueOf(x2) + "," + String.valueOf(y2);
        String colorFigura = String.valueOf(color);
        modelo.insertarCirculo(coordenadas, colorFigura);
    }

    public void dibujarCirculoBD(int x1, int y1, int x2, int y2, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);
        int radio = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        g.drawOval(x1 - radio, y1 - radio, 2 * radio, 2 * radio);
    }

    public void dibujarPoligonoRegular(int x1, int y1, int x2, int y2, int lados, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);

        int radio = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        double a = 0;
        double angulo = 0; //ángulo del primer vértice respecto a la horizontal.

        int x3, y3, x4, y4;
        x3 = (int) Math.floor(x1 + radio * Math.cos(angulo));
        y3 = (int) Math.floor(y1 + radio * Math.sin(angulo));
        for (int t = 1; t <= lados; t++) {
            a = (float) (t * (360.0f / lados) * (Math.PI / 180));
            x4 = (int) Math.floor(x1 + radio * Math.cos(a + angulo));
            y4 = (int) Math.floor(y1 + radio * Math.sin(a + angulo));
            g.drawLine(x3, y3, x4, y4); //lado
            x3 = x4;
            y3 = y4;
        }

        //Insertarlo en la base de datos:
        String coordenadas = String.valueOf(x1) + "," + String.valueOf(y1) + "," + String.valueOf(x2) + "," + String.valueOf(y2);
        String colorFigura = String.valueOf(color);
        modelo.insertarPoligonoRegular(coordenadas, colorFigura, lados);

    }

    public void dibujarPoligonoRegularBD(int x1, int y1, int x2, int y2, int lados, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);

        int radio = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        double a = 0;
        double angulo = 0; //ángulo del primer vértice respecto a la horizontal.

        int x3, y3, x4, y4;
        x3 = (int) Math.floor(x1 + radio * Math.cos(angulo));
        y3 = (int) Math.floor(y1 + radio * Math.sin(angulo));
        for (int t = 1; t <= lados; t++) {
            a = (float) (t * (360.0f / lados) * (Math.PI / 180));
            x4 = (int) Math.floor(x1 + radio * Math.cos(a + angulo));
            y4 = (int) Math.floor(y1 + radio * Math.sin(a + angulo));
            g.drawLine(x3, y3, x4, y4); //lado
            x3 = x4;
            y3 = y4;
        }
    }

    public void dibujarPoligonoRegularRelleno(int x1, int y1, int x2, int y2, int lados, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);

        int radio = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        double anguloInicial = Math.toRadians(0); // ángulo del primer vértice respecto a la horizontal.

        int[] xPoints = new int[lados];
        int[] yPoints = new int[lados];

        for (int t = 0; t < lados; t++) {
            double angulo = anguloInicial + t * 2 * Math.PI / lados;
            xPoints[t] = x1 + (int) (radio * Math.cos(angulo));
            yPoints[t] = y1 + (int) (radio * Math.sin(angulo));
        }

        g.fillPolygon(xPoints, yPoints, lados);

        //Insertarlo en la base de datos:
        String coordenadas = String.valueOf(x1) + "," + String.valueOf(y1) + "," + String.valueOf(x2) + "," + String.valueOf(y2);
        String colorFigura = String.valueOf(color);
        modelo.insertarPoligonoRegularRelleno(coordenadas, colorFigura, lados);
    }
    
    public void dibujarPoligonoRegularRellenoBD(int x1, int y1, int x2, int y2, int lados, Color color) {
        JPanel panel = vista.getjPanel1();
        Graphics g = panel.getGraphics();
        g.setColor(color);

        int radio = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        double anguloInicial = Math.toRadians(0); // ángulo del primer vértice respecto a la horizontal.

        int[] xPoints = new int[lados];
        int[] yPoints = new int[lados];

        for (int t = 0; t < lados; t++) {
            double angulo = anguloInicial + t * 2 * Math.PI / lados;
            xPoints[t] = x1 + (int) (radio * Math.cos(angulo));
            yPoints[t] = y1 + (int) (radio * Math.sin(angulo));
        }

        g.fillPolygon(xPoints, yPoints, lados);        
    }

}
