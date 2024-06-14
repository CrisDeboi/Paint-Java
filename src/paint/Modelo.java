package paint;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Modelo {

    public Connection connection;

    public Modelo() {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/paint", "root", "");
        } catch (SQLException e) {
            System.out.println("Conexion fallida");
        }
    }

    public String obtenerIDDibujo() {
        String queryDibujoID = "SELECT ID_dibujo FROM dibujos ORDER BY ID_dibujo DESC LIMIT 1";
        String dibujoID = "";
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(queryDibujoID)) {
            if (rs.next()) {
                dibujoID = rs.getString("ID_dibujo");
            }
            return dibujoID;
        } catch (SQLException e) {
            System.out.println("Ups");
        }
        return dibujoID;
    }

    public String obtenerIDDibujoBD(String nombre) {
        String queryDibujoID = "SELECT ID_dibujo FROM dibujos WHERE nombre = ? LIMIT 1";
        String dibujoID = "";
        try (PreparedStatement statement = connection.prepareStatement(queryDibujoID)) {
            statement.setString(1, nombre);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    dibujoID = rs.getString("ID_dibujo");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando el ID del dibujo");
        }
        return dibujoID;
    }

    public int contarFiguras(int idDibujo) {
        String sql = "SELECT COUNT(*) AS total FROM figuras WHERE ID_dibujo = ?";
        int totalFiguras = 0;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idDibujo);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    totalFiguras = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups contando figuras");
        }
        return totalFiguras;
    }

    public String obtenerTipoFigura(int idDibujo, int offset) {
        String queryFiguraTipo = "SELECT tipo FROM figuras WHERE ID_dibujo = ? LIMIT 1 OFFSET ?";
        String tipoFigura = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setInt(2, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    tipoFigura = rs.getString("tipo");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando el tipo de figura");
        }
        return tipoFigura;
    }

    public void crearDibujo() {
        String sql = "INSERT INTO dibujos (nombre) VALUES (?)";
        try {
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, "Dibujo");
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ups creando");
        }
    }

    public List<String> obtenerNombresDibujos() {
        List<String> nombres = new ArrayList<>();
        String sql = "SELECT nombre FROM dibujos WHERE nombre <> 'Dibujo'";
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                nombres.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando nombres de dibujos");
        }
        return nombres;
    }

    public void eliminarDibujo(String nombre) {
        String sql = "DELETE FROM dibujos WHERE nombre = ?";
        try (PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, nombre);
            int rowsAffected = query.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Dibujo eliminado exitosamente");
            } else {
                System.out.println("No se encontró ningún dibujo con el nombre especificado");
            }
        } catch (SQLException e) {
            System.out.println("Ups eliminando dibujo");
        }

    }

    public void eliminarDibujoEstandar() {
        String sql = "DELETE FROM dibujos WHERE nombre = ?";
        String nombre = "Dibujo";
        try (PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, nombre);
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ups eliminando dibujos estandares");
        }
    }

    public void modificarNombre(String nuevoNombre) {
        String sql = "UPDATE dibujos SET nombre = ? WHERE ID_dibujo = ?";
        try (PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, nuevoNombre);
            query.setInt(2, Integer.parseInt(obtenerIDDibujo()));
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ups modificando");
        }
    }

    public void insertarPunto(String coordenadas, String color) {
        String tipo = "Punto";
        String sql = "INSERT INTO figuras (tipo,color,coordenadas, ID_dibujo) VALUES (?,?,?,?)";
        String dibujoID = obtenerIDDibujo();

        try {
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, tipo);
            query.setString(2, color);
            query.setString(3, coordenadas);
            query.setString(4, dibujoID);
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ups insertando Punto");
        }
    }

    public void insertarRecta(String coordenadas, String color) {
        String tipo = "Recta";
        String sql = "INSERT INTO figuras (tipo,color,coordenadas, ID_dibujo) VALUES (?,?,?,?)";
        String dibujoID = obtenerIDDibujo();

        try {
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, tipo);
            query.setString(2, color);
            query.setString(3, coordenadas);
            query.setString(4, dibujoID);
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ups insertando Recta");
        }
    }

    public void insertarCirculo(String coordenadas, String color) {
        String tipo = "Circulo";
        String sql = "INSERT INTO figuras (tipo,color,coordenadas, ID_dibujo) VALUES (?,?,?,?)";
        String dibujoID = obtenerIDDibujo();

        try {
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, tipo);
            query.setString(2, color);
            query.setString(3, coordenadas);
            query.setString(4, dibujoID);
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ups insertando Circulo");
        }
    }

    public void insertarPoligonoRegular(String coordenadas, String color, int lados) {
        String tipo = "Poligono Regular";
        String sql = "INSERT INTO figuras (tipo,color,lados, coordenadas, ID_dibujo) VALUES (?,?,?,?,?)";
        String dibujoID = obtenerIDDibujo();

        try {
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, tipo);
            query.setString(2, color);
            query.setInt(3, lados);
            query.setString(4, coordenadas);
            query.setString(5, dibujoID);
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ups insertando Poligono Regular");
        }
    }

    public void insertarPoligonoRegularRelleno(String coordenadas, String color, int lados) {
        String tipo = "Poligono Regular Relleno";
        String sql = "INSERT INTO figuras (tipo,color,lados, coordenadas, ID_dibujo) VALUES (?,?,?,?,?)";
        String dibujoID = obtenerIDDibujo();

        try {
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, tipo);
            query.setString(2, color);
            query.setInt(3, lados);
            query.setString(4, coordenadas);
            query.setString(5, dibujoID);
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ups insertando Poligono Regular Relleno");
        }
    }

    public String obtenerCoordsPunto(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT coordenadas FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String coordenadas = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    coordenadas = rs.getString("coordenadas");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando las coordenadas del punto");
        }
        return coordenadas;
    }

    public String obtenerColorPunto(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT color FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String color = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    color = rs.getString("color");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando los colores del punto");
        }
        return color;
    }

    public String obtenerCoordsRecta(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT coordenadas FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String coordenadas = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    coordenadas = rs.getString("coordenadas");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando las coordenadas de la recta");
        }
        return coordenadas;
    }

    public String obtenerColorRecta(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT color FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String color = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    color = rs.getString("color");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando los colores de la recta");
        }
        return color;
    }

    public String obtenerCoordsCirculo(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT coordenadas FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String coordenadas = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    coordenadas = rs.getString("coordenadas");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando las coordenadas del circulo");
        }
        return coordenadas;
    }

    public String obtenerColorCirculo(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT color FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String color = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    color = rs.getString("color");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando los colores del circulo");
        }
        return color;
    }

    public String obtenerCoordsPoligonoRegular(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT coordenadas FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String coordenadas = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    coordenadas = rs.getString("coordenadas");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando las coordenadas del poligono regular");
        }
        return coordenadas;
    }

    public String obtenerColorPoligonoRegular(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT color FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String color = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    color = rs.getString("color");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando los colores del poligono regular");
        }
        return color;
    }

    public int obtenerLadosPoligonoRegular(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT lados FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String lados = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    lados = rs.getString("lados");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando los colores del poligono regular");
        }
        return Integer.parseInt(lados);
    }

    public String obtenerCoordsPoligonoRegularRelleno(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT coordenadas FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String coordenadas = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    coordenadas = rs.getString("coordenadas");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando las coordenadas del poligono regular relleno");
        }
        return coordenadas;
    }

    public String obtenerColorPoligonoRegularRelleno(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT color FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String color = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    color = rs.getString("color");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando los colores del poligono regular relleno");
        }
        return color;
    }

    public int obtenerLadosPoligonoRegularRelleno(int idDibujo, String tipo, int offset) {
        String queryFiguraTipo = "SELECT lados FROM figuras WHERE ID_dibujo = ? AND tipo = ? LIMIT 1 OFFSET ?";
        String lados = "";
        try (PreparedStatement statement = connection.prepareStatement(queryFiguraTipo)) {
            statement.setInt(1, idDibujo);
            statement.setString(2, tipo);
            statement.setInt(3, offset);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    lados = rs.getString("lados");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ups pillando los lados del poligono regular relleno");
        }
        return Integer.parseInt(lados);
    }

    public void guardarFigurasEnSVG(String nombreDibujo, String filePath) {
        int idDibujo = Integer.parseInt(obtenerIDDibujoBD(nombreDibujo));
        int figuras = contarFiguras(idDibujo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\">\n");

            int contPunto = 0;
            int contRecta = 0;
            int contCirculo = 0;
            int contPoligonoRegular = 0;
            int contPoligonoRegularRelleno = 0;

            for (int i = 0; i < figuras; i++) {
                String tipoFigura = obtenerTipoFigura(idDibujo, i);
                String coordenadas;
                String color;

                switch (tipoFigura) {
                    case "Punto":
                        coordenadas = obtenerCoordsPunto(idDibujo, tipoFigura, contPunto);
                        color = obtenerColorPunto(idDibujo, tipoFigura, contPunto);
                        contPunto++;
                        String[] coordsPunto = coordenadas.split(",");
                        writer.write(String.format("<circle cx=\"%s\" cy=\"%s\" r=\"5\" fill=\"%s\" />\n",
                                coordsPunto[0], coordsPunto[1], color));
                        break;
                    case "Recta":
                        coordenadas = obtenerCoordsRecta(idDibujo, tipoFigura, contRecta);
                        color = obtenerColorRecta(idDibujo, tipoFigura, contRecta);
                        contRecta++;
                        String[] coordsRecta = coordenadas.split(",");
                        writer.write(String.format("<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" stroke=\"%s\" />\n",
                                coordsRecta[0], coordsRecta[1], coordsRecta[2], coordsRecta[3], color));
                        break;
                    case "Circulo":
                        coordenadas = obtenerCoordsCirculo(idDibujo, tipoFigura, contCirculo);
                        color = obtenerColorCirculo(idDibujo, tipoFigura, contCirculo);
                        contCirculo++;
                        String[] coordsCirculo = coordenadas.split(",");
                        int x1 = Integer.parseInt(coordsCirculo[0]);
                        int y1 = Integer.parseInt(coordsCirculo[1]);
                        int x2 = Integer.parseInt(coordsCirculo[2]);
                        int y2 = Integer.parseInt(coordsCirculo[3]);
                        int radio = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                        writer.write(String.format("<circle cx=\"%d\" cy=\"%d\" r=\"%d\" stroke=\"%s\" fill=\"none\" />\n",
                                x1, y1, radio, color));
                        break;
                    case "Poligono Regular":
                        coordenadas = obtenerCoordsPoligonoRegular(idDibujo, tipoFigura, contPoligonoRegular);
                        color = obtenerColorPoligonoRegular(idDibujo, tipoFigura, contPoligonoRegular);
                        int lados = obtenerLadosPoligonoRegular(idDibujo, tipoFigura, contPoligonoRegular);
                        contPoligonoRegular++;
                        String[] coordsPoligono = coordenadas.split(",");
                        x1 = Integer.parseInt(coordsPoligono[0]);
                        y1 = Integer.parseInt(coordsPoligono[1]);
                        x2 = Integer.parseInt(coordsPoligono[2]);
                        y2 = Integer.parseInt(coordsPoligono[3]);
                        int[] xPoints = new int[lados];
                        int[] yPoints = new int[lados];
                        int radioPoligono = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                        for (int t = 0; t < lados; t++) {
                            double angulo = t * 2 * Math.PI / lados;
                            xPoints[t] = x1 + (int) (radioPoligono * Math.cos(angulo));
                            yPoints[t] = y1 + (int) (radioPoligono * Math.sin(angulo));
                        }
                        writer.write("<polygon points=\"");
                        for (int j = 0; j < lados; j++) {
                            writer.write(xPoints[j] + "," + yPoints[j] + " ");
                        }
                        writer.write(String.format("\" stroke=\"%s\" fill=\"none\" />\n", color));
                        break;
                    case "Poligono Regular Relleno":
                        coordenadas = obtenerCoordsPoligonoRegularRelleno(idDibujo, tipoFigura, contPoligonoRegularRelleno);
                        color = obtenerColorPoligonoRegularRelleno(idDibujo, tipoFigura, contPoligonoRegularRelleno);
                        lados = obtenerLadosPoligonoRegularRelleno(idDibujo, tipoFigura, contPoligonoRegularRelleno);
                        contPoligonoRegularRelleno++;
                        coordsPoligono = coordenadas.split(",");
                        x1 = Integer.parseInt(coordsPoligono[0]);
                        y1 = Integer.parseInt(coordsPoligono[1]);
                        x2 = Integer.parseInt(coordsPoligono[2]);
                        y2 = Integer.parseInt(coordsPoligono[3]);
                        xPoints = new int[lados];
                        yPoints = new int[lados];
                        radioPoligono = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                        for (int t = 0; t < lados; t++) {
                            double angulo = t * 2 * Math.PI / lados;
                            xPoints[t] = x1 + (int) (radioPoligono * Math.cos(angulo));
                            yPoints[t] = y1 + (int) (radioPoligono * Math.sin(angulo));
                        }
                        writer.write("<polygon points=\"");
                        for (int j = 0; j < lados; j++) {
                            writer.write(xPoints[j] + "," + yPoints[j] + " ");
                        }
                        writer.write(String.format("\" fill=\"%s\" />\n", color));
                        break;
                }
            }

            writer.write("</svg>");
            System.out.println("Archivo SVG creado");
        } catch (IOException e) {
            System.out.println("Error creating SVG file: " + e.getMessage());
        }
    }

}
