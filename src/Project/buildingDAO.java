package Project;

import java.sql.*;

public class buildingDAO {

    public void create(Connection conn, building Building) {
        Statement statement = null;

        try {
            String query = String.format("INSERT INTO \"Building\" (address, building_scale, city, state, description) VALUES ('%s', '%s', '%s', '%s', '%s');",
                    Building.getAddress(),
                    Building.getBuildingScale(),
                    Building.getCity(),
                    Building.getState(),
                    Building.getDescription());

            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Imóvel adicionado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void read(Connection conn) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM \"Building\"";

            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Endereço: " + rs.getString("address"));
                System.out.println("Tamanho: " + rs.getString("building_scale"));
                System.out.println("Cidade: " + rs.getString("city"));
                System.out.println("Estado: " + rs.getString("state"));
                System.out.println("Descrição: " + rs.getString("description"));
                System.out.println("---------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ler os dados: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void search(Connection conn, String columnName, String value) {
        String query = "SELECT * FROM \"Building\" WHERE " + columnName + "= ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (columnName.equals("id")) {
                pstmt.setInt(1, Integer.parseInt(value));
            } else {
                pstmt.setString(1, value);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Endereço: " + rs.getString("address"));
                    System.out.println("Tamanho: " + rs.getString("building_scale"));
                    System.out.println("Cidade: " + rs.getString("city"));
                    System.out.println("Estado: " + rs.getString("state"));
                    System.out.println("Descrição: " + rs.getString("description"));
                    System.out.println("---------------------------------");
                    found = true;
                }
                if (!found) {
                    System.out.println("Nenhum imóvel encontrado com " + columnName + " = " + value);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar imóveis: " + e.getMessage());
        }
    }

    public void update(Connection conn, building Building) {
        Statement statement = null;

        try {
            String query = String.format("UPDATE \"Building\" SET address = '%s', building_scale = '%s', city = '%s', state = '%s', description = '%s'  WHERE ID = '%d';",
                    Building.getAddress(),
                    Building.getBuildingScale(),
                    Building.getCity(),
                    Building.getState(),
                    Building.getDescription(),
                    Building.getId()
            );
            statement = conn.createStatement();
            statement.executeUpdate(query);
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Imóvel atualizado com sucesso!");
            } else {
                System.out.println("Nenhum imóvel encontrado com o ID fornecido");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o imóvel: " + e.getMessage());
        }
    }

    public void delete(Connection conn, building Building) {
        Statement statement = null;
        try {
            String query = String.format("DELETE FROM \"Building\" where id = '%d'",
                    Building.getId()
            );

            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(query);


            if (rowsAffected > 0) {
                System.out.println("Imóvel deletado com sucesso!");
            } else {
                System.out.println("Nenhum imóvel encontrado com o ID fornecido.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar o imóvel: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

