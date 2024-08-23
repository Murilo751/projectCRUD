import Project.building;
import Project.buildingDAO;
import Project.connection;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        connection db = new connection();
        Connection conn = db.connect_to_db("CRUD", "postgres", "232827751");

        buildingDAO buildingDAO = new buildingDAO();
        Scanner sc = new Scanner(System.in);

        int option = -1;
        while (option != 6) {
            try {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Criar um novo imóvel");
                System.out.println("2. Listar todos os imóveis");
                System.out.println("3. Buscar tabela por valor");
                System.out.println("4. Atualizar um imóvel");
                System.out.println("5. Deletar um imóvel");
                System.out.println("6. Sair");

                option = sc.nextInt();
                sc.nextLine();


                switch (option) {
                    case 1:
                        System.out.println("Digite o endereço do imóvel:");
                        String address = sc.nextLine().toUpperCase();
                        if (address.length() > 300){
                            System.out.println("Erro: O endereço não pode ter mais do que 300 caracteres.");
                            break;
                        }
                        System.out.println("Digite o tamanho do imóvel:");
                        String building_scale = sc.nextLine().toUpperCase();
                        if (building_scale.length() > 40){
                            System.out.println("Erro: O tamanho do imóvel não pode ter mais do que 40 caracteres.");
                            break;
                        }
                        System.out.println("Digite a cidade do imóvel:");
                        String city = sc.nextLine().toUpperCase();
                        if (city.length() > 100){
                            System.out.println("Erro: A cidade não pode ter mais do que 100 caracteres.");
                            break;
                        }
                        System.out.println("Digite o estado do imóvel:");
                        String state = sc.nextLine().toUpperCase();
                        if (state.length() > 2){
                            System.out.println("Erro: O estado não pode ter mais do que 2 caracteres.");
                            break;
                        }
                        System.out.println("Digite a descrição do imóvel:");
                        String description = sc.nextLine();

                        building property = new building();
                        property.setAddress(address);
                        property.setBuildingScale(building_scale);
                        property.setCity(city);
                        property.setState(state);
                        property.setDescription(description);

                        buildingDAO.create(db.getConnection(), property);
                        break;

                    case 2:
                        buildingDAO.read(db.getConnection());
                        break;

                    case 3:
                        System.out.println("Escolha o critério de busca:");
                        System.out.println("1. Buscar por ID");
                        System.out.println("2. Buscar por endereço");
                        System.out.println("3. Buscar por tamanho");
                        System.out.println("4. Buscar por cidade");
                        System.out.println("5. Buscar por estado");
                        System.out.println("6. Voltar ao menu principal");

                        int searchOption = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Digite o valor para a busca:");
                        String value = sc.nextLine();

                        String columnName = "";
                        switch (searchOption) {
                            case 1:
                                columnName = "id";
                                break;
                            case 2:
                                columnName = "building_scale";
                                break;
                            case 3:
                                columnName = "address";
                                break;
                            case 4:
                                columnName = "city";
                                break;
                            case 5:
                                columnName = "state";
                                break;
                            case 6:
                                columnName = "description";
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                continue;
                        }

                        buildingDAO.search(conn, columnName, value);
                        break;

                    case 4:
                        System.out.println("Digite o ID do imóvel a ser atualizado:");
                        int idUpdate = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite o novo endereço  do imóvel:");
                        String newAddress = sc.nextLine().toUpperCase();
                        if (newAddress.length() > 300){
                            System.out.println("Erro: O endereço não pode ter mais do que 300 caracteres.");
                            break;
                        }
                        System.out.println("Digite a novo tamanho do imóvel:");
                        String newBuildingScale = sc.nextLine().toUpperCase();
                        if (newBuildingScale.length() > 40){
                            System.out.println("Erro: O tamanho do imóvel não pode ter mais do que 40 caracteres.");
                            break;
                        }
                        System.out.println("Digite o nova cidade  do imóvel:");
                        String newCity = sc.nextLine().toUpperCase();
                        if (newCity.length() > 100){
                            System.out.println("Erro: A cidade não pode ter mais do que 100 caracteres.");
                            break;
                        }
                        System.out.println("Digite a novo  estado  do imóvel:");
                        String newState = sc.nextLine().toUpperCase();
                        if (newState.length() > 3){
                            System.out.println("Erro: O estado não pode ter mais do que 2 caracteres.");
                            break;
                        }
                        System.out.println("Digite o nova descrição do imóvel:");
                        String newDescription = sc.nextLine();


                        building buildingUpdate = new building();
                        buildingUpdate.setId(idUpdate);
                        buildingUpdate.setAddress(newAddress);
                        buildingUpdate.setBuildingScale(newBuildingScale);
                        buildingUpdate.setCity(newCity);
                        buildingUpdate.setState(newState);
                        buildingUpdate.setDescription(newDescription);

                        buildingDAO.update(db.getConnection(), buildingUpdate);
                        break;

                    case 5:
                        System.out.println("Digite o ID do imóvel a ser deletado:");
                        int idDelete = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Você tem certeza que quer deletar o imóvel de ID: " + idDelete + "\n Digite (S) para sim ou (N) para não");
                        String confirmDelete = sc.nextLine();
                        if (confirmDelete.equalsIgnoreCase("S")) {
                            building buildingDelete = new building();
                            buildingDelete.setId(idDelete);
                            buildingDAO.delete(db.getConnection(), buildingDelete);
                        } else if (confirmDelete.equalsIgnoreCase("N")) {
                            System.out.println("Operação de exclusão abortada.");
                        } else {
                            System.out.println("Confirmação não reconhecida");
                        }
                        break;

                    case 6:
                        System.out.println("Saindo...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
