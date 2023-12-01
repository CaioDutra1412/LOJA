package dwbe.lojatenis;

import dwbe.lojatenis.Controller.*;
import dwbe.lojatenis.Model.*;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //LimparTodasTabelas();

        /*fornecedorController fornecedorControllerTeste = new fornecedorController();
        Fornecedor fonecedorTeste = new Fornecedor("Thiago Cotta", "123.456.789-00", "Oscar Vidal - Juiz de Fora", "Homem", "31 9 7161-0440", "Thiago.cotta@gmail.com", "123456789", 326, "Nike", "09-03-2022", "Grande", "Venda de calçados", "Ativo");
        fornecedorControllerTeste.cadastrarFornecedor(fonecedorTeste);
        System.out.println(fonecedorTeste.getId());

        produtoController produtoControllerTeste = new produtoController();
        var prodteste = new Produto(200, "36", "Branco", "Nike", "Esportivo", fonecedorTeste.getId());
        produtoControllerTeste.cadastrarProduto(prodteste);
        System.out.println(prodteste.getId());*/

        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            System.out.println("1 - Fornecedor");
            System.out.println("2 - Cliente");
            System.out.println("3 - Produto");
            System.out.println("4 - Vender");
            System.out.println("exit - Finalizar");

            System.out.print("O que deseja? ");
            String resposta = scanner.next();

            switch (resposta) {
                case "1":
                    System.out.println("Opção Fornecedor selecionada.");
                    menuFornecedor();
                    break;
                case "2":
                    System.out.println("Opção Cliente selecionada.");
                    menuCliente();
                    break;
                case "3":
                    System.out.println("Opção Produto selecionada.");
                    menuProduto();
                    break;
                case "4":
                    System.out.println("Opção Vender selecionada.");
                    menuVender();
                    break;
                case "exit":
                    System.out.println("Finalizando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        } while (true);
    }

    private static void LimparTodasTabelas() {
        var connection = DatabaseConnection.getConnection();

        String sqlProduto = "DELETE FROM Produto";
        String sqlFornecedor = "DELETE FROM Fornecedor";
        String sqlCliente = "DELETE FROM Cliente";
        String sqlPessoa = "DELETE FROM Pessoa";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlProduto)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pstmt = connection.prepareStatement(sqlFornecedor)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pstmt = connection.prepareStatement(sqlCliente)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pstmt = connection.prepareStatement(sqlPessoa)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuClear(){
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    public static void menuFornecedor() {
        FornecedorController fornecedorController = new FornecedorController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            System.out.println("1 - Cadastrar Fornecedor");
            System.out.println("2 - Alterar Fornecedor");
            System.out.println("3 - Excluir Fornecedor");
            System.out.println("4 - Listar Fornecedores");
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String resposta = scanner.next();

            switch (resposta) {
                case "1":
                    System.out.println("Opção Cadastrar Fornecedor selecionada.");
                    cadastrarFornecedor();
                    break;
                case "2":
                    System.out.println("Opção Alterar Fornecedor selecionada.");
                    alterarFornecedor();
                    break;
                case "3":
                    menuClear();
                    listarFornecedoresMenu(false);
                    System.out.println("Qual Fornecedor você deseja apagar? ");
                    String respostaExcluirFornecedor = scanner.next();
                    fornecedorController.excluirFornecedor(Integer.parseInt(respostaExcluirFornecedor));
                    break;
                case "4":
                    System.out.println("Opção Listar Fornecedores selecionada");
                    listarFornecedoresMenu(true);
                    break;
                case "0":
                    System.out.println("Opção Voltar selecionada.");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (true);
    }
    public static void cadastrarFornecedor() {
        FornecedorController fornecedorController = new FornecedorController();

        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            System.out.println("Preencha o formulário");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Cpf: ");
            String cpf = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Sexo: ");
            String sexo = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Cnpj: ");
            String cnpj = scanner.nextLine();
            System.out.print("Numero de inscricao: ");
            int numeroInscricao = scanner.nextInt();
            System.out.print("Nome Fantasia: ");
            String nomeFantasia = scanner.nextLine();
            System.out.print("Data De Abertura: ");
            String dataDeAbertura = scanner.nextLine();
            System.out.print("Porte: ");
            String porte = scanner.nextLine();
            System.out.print("Atividade Economica Principal: ");
            String atividadeEconomicaPrincipal = scanner.nextLine();
            System.out.print("Situação Cadastral: ");
            String situacaoCadastral = scanner.nextLine();

            Fornecedor novoFornecedor = new Fornecedor(nome, cpf, endereco, sexo, telefone, email, cnpj, numeroInscricao, nomeFantasia, dataDeAbertura, porte, atividadeEconomicaPrincipal, situacaoCadastral);
            //fornecedorController.cadastrarFornecedor(nome, cpf, endereco, sexo, telefone, email, cnpj, numeroInscricao, nomeFantasia, dataDeAbertura, porte, atividadeEconomicaPrincipal, situacaoCadastral);

            System.out.print("Deseja adicionar um produto a esse fornecedor? (S/N): ");
            String respostaAdicionarProduto = scanner.next();
            if (respostaAdicionarProduto.equalsIgnoreCase("S")) {
                cadastrarProduto(novoFornecedor.getId());
            }

            System.out.print("Deseja adicionar outro fornecedor? (S/N): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
        } while (true);
    }
    public static void alterarFornecedor() {
        FornecedorController fornecedorController = new FornecedorController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            listarFornecedoresMenu(false);
            System.out.println("Id do fornecedor que deseja alterar");
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String resposta = scanner.next();

            switch (resposta) {
                case "0":
                    System.out.println("Opção Voltar selecionada.");
                    return;
                default:
                    var fornecedorEncontrado = fornecedorController.buscarFornecedor(Integer.parseInt(resposta));
                    if (fornecedorEncontrado != null) {
                        menuClear();
                        System.out.println(fornecedorEncontrado);
                        System.out.println("O que deseja alterar?");
                        System.out.println("1 - Perfil do fornecedor");
                        System.out.println("2 - Produtos do fornecedor");
                        System.out.println("3 - Adicionar produtos ao fornecedor");
                        System.out.println("0 - Voltar");
                        System.out.print("O que deseja? ");
                        String respostaEscolhaDeAlteracao = scanner.next();

                        switch (respostaEscolhaDeAlteracao) {
                            case "1":
                                System.out.println("Opção Perfil do fornecedor selecionada.");
                                alterarFornecedorPerfil(fornecedorEncontrado);
                                return;
                            case "2":
                                System.out.println("Opção Produtos do fornecedor selecionada.");
                                alterarFornecedorProdutos(fornecedorEncontrado);
                                return;
                            case "3":
                                System.out.println("Opção Adicionar produtos ao fornecedor selecionada.");
                                AdicionarProdutosFornecedor(fornecedorEncontrado);
                                return;
                            case "0":
                                System.out.println("Opção Voltar selecionada.");
                                return;
                            default:
                        }
                    } else {
                        System.out.println("Fornecedor não encontrado.");
                    }
            }
        } while (true);
    }
    public static void alterarFornecedorPerfil(Fornecedor fornecedorEncontrado) {
        Scanner scanner = new Scanner(System.in);
        menuClear();
        System.out.println(fornecedorEncontrado);
        System.out.println("O que deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Cpf");
        System.out.println("3 - Endereço");
        System.out.println("4 - Sexo");
        System.out.println("5 - Telefone");
        System.out.println("6 - Email");
        System.out.println("7 - Cnpj");
        System.out.println("8 - Número Incrição");
        System.out.println("9 - Nome Fantasia");
        System.out.println("10 - Data de abertura");
        System.out.println("11 - Porte");
        System.out.println("12 - Atividade economica principal");
        System.out.println("13 - Situação cadastral");
        System.out.println("0 - Voltar");
        System.out.print("O que deseja? ");
        String respostaAlteracao = scanner.next();

        switch (respostaAlteracao) {
            case "1":
                System.out.print("Qual o novo nome? ");
                String novoNome = scanner.nextLine();
                fornecedorEncontrado.setNome(novoNome);
                break;
            case "2":
                System.out.print("Qual o novo cpf? ");
                String novoCpf = scanner.nextLine();
                fornecedorEncontrado.setCpf(novoCpf);
                break;
            case "3":
                System.out.print("Qual a nova endereço? ");
                String novoEndereco = scanner.nextLine();
                fornecedorEncontrado.setEndereco(novoEndereco);
                break;
            case "4":
                System.out.print("Qual o sexo? ");
                String novoSexo = scanner.nextLine();
                fornecedorEncontrado.setSexo(novoSexo);
                break;
            case "5":
                System.out.print("Qual o novo telefone? ");
                String novoTelefone = scanner.nextLine();
                fornecedorEncontrado.setTelefone(novoTelefone);
                break;
            case "6":
                System.out.print("Qual o novo email? ");
                String novoEmail = scanner.nextLine();
                fornecedorEncontrado.setEndereco(novoEmail);
                break;
            case "7":
                System.out.print("Qual o novo cnpj? ");
                String novoCnpj = scanner.nextLine();
                fornecedorEncontrado.setCnpj(novoCnpj);
                break;
            case "8":
                System.out.print("Qual o novo número de inscrição? ");
                int novoNumeroInscricao = scanner.nextInt();
                fornecedorEncontrado.setNumeroInscricao(novoNumeroInscricao);
                break;
            case "9":
                System.out.print("Qual o novo nome fantasia? ");
                String novoNomeFantasia = scanner.nextLine();
                fornecedorEncontrado.setNomeFantasia(novoNomeFantasia);
                break;
            case "10":
                System.out.print("Qual a nova data de abertura? ");
                String novaDataDeAbertura = scanner.nextLine();
                fornecedorEncontrado.setDataDeAbertura(novaDataDeAbertura);
                break;
            case "11":
                System.out.print("Qual o novo porte? ");
                String novoPorte = scanner.nextLine();
                fornecedorEncontrado.setPorte(novoPorte);
                break;
            case "12":
                System.out.print("Qual a nova atividade economica principal? ");
                String novaAtividadeEconomicaPrincipal = scanner.nextLine();
                fornecedorEncontrado.setAtividadeEconomicaPrincipal(novaAtividadeEconomicaPrincipal);
                break;
            case "13":
                System.out.print("Qual a nova situacao cadastral? ");
                String novoSituacaoCadastral = scanner.nextLine();
                fornecedorEncontrado.setSituacaoCadastral(novoSituacaoCadastral);
                break;
            case "0":
                System.out.println("Opção Voltar selecionada.");
                return;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
    }
    public static void alterarFornecedorProdutos(Fornecedor fornecedorEncontrado) {
        alterarProduto(fornecedorEncontrado);
    }
    public static void AdicionarProdutosFornecedor(Fornecedor fornecedorEncontrado) {
        ProdutoController produtoController = new ProdutoController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            listarProdutosMenu(false);
            System.out.println("Id do produto que deseja adicionar ao fornecedor " + fornecedorEncontrado.getNomeFantasia());
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String resposta = scanner.nextLine();

            switch (resposta) {
                case "0":
                    System.out.println("Opção Voltar selecionada.");
                    return;
                default:
                    Produto produtoEncontrado = produtoController.buscarProduto(Integer.parseInt(resposta));

                    if (produtoEncontrado != null) {
                        menuClear();
                        produtoEncontrado.setFornecedorId(fornecedorEncontrado.getId());
                        break;
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
            }
        } while (true);
    }
    public static void listarFornecedoresMenu(boolean Emenu) {
        FornecedorController fornecedorController = new FornecedorController();
        if(Emenu){
            menuClear();
            Scanner scanner = new Scanner(System.in);
            do {
                for (var fornecedor : fornecedorController.listarFornecedores()) {
                    System.out.println(fornecedor);
                }
                System.out.println("0 - Voltar");
                System.out.print("O que deseja? ");
                String resposta = scanner.nextLine();
                switch (resposta) {
                    case "0":
                        System.out.println("Opção Voltar selecionada.");
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            } while (true);
        }else {
            for (var fornecedor : fornecedorController.listarFornecedores()) {
                System.out.println(fornecedor);
            }
        }
    }


    public static void menuCliente() {
        ClienteController clienteController = new ClienteController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Alterar Cliente");
            System.out.println("3 - Excluir Cliente");
            System.out.println("4 - Listar Clientes");
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String resposta = scanner.next();

            switch (resposta) {
                case "1":
                    System.out.println("Opção Cadastrar Cliente selecionada.");
                    cadastrarCliente();
                    break;
                case "2":
                    System.out.println("Opção Alterar Cliente selecionada.");
                    alterarCliente();
                    break;
                case "3":
                    menuClear();
                    listarClientesMenu(false);
                    System.out.println("Qual Cliente você deseja apagar? ");
                    String respostaExcluirCliente = scanner.next();
                    clienteController.excluirCliente(Integer.parseInt(respostaExcluirCliente));
                    break;
                case "4":
                    System.out.println("Opção Listar Clientes selecionada");
                    listarClientesMenu(true);
                    break;
                case "0":
                    System.out.println("Opção Voltar selecionada.");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (true);
    }
    public static void cadastrarCliente() {
        ClienteController clienteController = new ClienteController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            System.out.println("Preencha o formulário");
            System.out.print("Nome: ");
            String nome = scanner.next();
            System.out.print("Cpf: ");
            String cpf = scanner.next();
            System.out.print("Endereço: ");
            String endereco = scanner.next();
            System.out.print("Sexo: ");
            String sexo = scanner.next();
            System.out.print("Telefone: ");
            String telefone = scanner.next();
            System.out.print("Email: ");
            String email = scanner.next();
            System.out.print("Status: ");
            String status = scanner.next();

            Cliente novoCliente = new Cliente(nome, cpf, endereco, sexo, telefone, email, status);

            //clienteController.cadastrarCliente(novoCliente);
            System.out.print("Deseja adicionar outro cliente? (S/N): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
        } while (true);
    }
    public static void alterarCliente() {
        ClienteController clienteController = new ClienteController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            listarClientesMenu(false);
            System.out.println("Id do cliente que deseja alterar");
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String resposta = scanner.next();

            switch (resposta) {
                case "0":
                    System.out.println("Opção Voltar selecionada.");
                    return;
                default:
                    var clienteEncontrado = clienteController.buscarCliente(Integer.parseInt(resposta));
                    if (clienteEncontrado != null) {
                        menuClear();
                        System.out.println(clienteEncontrado);
                        System.out.println("O que deseja alterar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Cpf");
                        System.out.println("3 - Endereço");
                        System.out.println("4 - Sexo");
                        System.out.println("5 - Telefone");
                        System.out.println("6 - Email");
                        System.out.println("7 - Status");
                        System.out.println("0 - Voltar");
                        System.out.print("O que deseja? ");
                        String respostaAlteracao = scanner.next();

                        switch (respostaAlteracao) {
                            case "1":
                                System.out.print("Qual o novo nome? ");
                                String novoNome = scanner.nextLine();
                                clienteEncontrado.setNome(novoNome);
                                break;
                            case "2":
                                System.out.print("Qual o novo cpf? ");
                                String novoCpf = scanner.nextLine();
                                clienteEncontrado.setCpf(novoCpf);
                                break;
                            case "3":
                                System.out.print("Qual a nova endereço? ");
                                String novoEndereco = scanner.nextLine();
                                clienteEncontrado.setEndereco(novoEndereco);
                                break;
                            case "4":
                                System.out.print("Qual o sexo? ");
                                String novoSexo = scanner.nextLine();
                                clienteEncontrado.setSexo(novoSexo);
                                break;
                            case "5":
                                System.out.print("Qual o novo telefone? ");
                                String novoTelefone = scanner.nextLine();
                                clienteEncontrado.setTelefone(novoTelefone);
                                break;
                            case "6":
                                System.out.print("Qual o novo email? ");
                                String novoEmail = scanner.nextLine();
                                clienteEncontrado.setEndereco(novoEmail);
                                break;
                            case "7":
                                System.out.print("Qual o novo status? ");
                                String novoStatus = scanner.nextLine();
                                clienteEncontrado.setStatus(novoStatus);
                                break;
                            case "0":
                                System.out.println("Opção Voltar selecionada.");
                                return;
                            default:
                                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
            }
        } while (true);
    }
    public static void listarClientesMenu(boolean Emenu) {
        ClienteController clienteController = new ClienteController();
        if(Emenu){
            menuClear();
            Scanner scanner = new Scanner(System.in);
            do {
                for (var cliente : clienteController.listarClientes()) {
                    System.out.println(cliente);
                }
                System.out.println("0 - Voltar");
                System.out.print("O que deseja? ");
                String resposta = scanner.next();
                switch (resposta) {
                    case "0":
                        System.out.println("Opção Voltar selecionada.");
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            } while (true);
        }else {
            for (var cliente : clienteController.listarClientes()) {
                System.out.println(cliente);
            }
        }
    }


    public static void menuProduto() {
        Scanner scanner = new Scanner(System.in);
        menuClear();
        do {
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Alterar Produto");
            System.out.println("3 - Excluir Produto");
            System.out.println("4 - Listar Produtos");
            System.out.println("5 - Comprar Produtos");
            System.out.println("6 - Listar Estoque");
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String resposta = scanner.next();

            switch (resposta) {
                case "1":
                    System.out.println("Opção Cadastrar Produto selecionada.");
                    //cadastrarProduto();
                    break;
                case "2":
                    System.out.println("Opção Alterar Produto selecionada.");
                    //alterarProduto(null);
                    break;
                case "3":
                    System.out.println("Opção Excluir Produto selecionada.");
                    excluirProduto();
                    break;
                case "4":
                    System.out.println("Opção Listar Produtos selecionada");
                    listarProdutosMenu(true);
                    break;
                case "5":
                    System.out.println("Opção Comprar Produtos selecionada.");
                    ComprarDoFornecedor();
                    break;
                case "6":
                    System.out.println("Opção Listar Estoque selecionada");
                    listarEstoqueMenu();
                    break;
                case "0":
                    System.out.println("Opção Voltar selecionada.");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (true);
    }
    public static void cadastrarProduto(int idFornecedor) {
        ProdutoController produtoController = new ProdutoController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            System.out.print("Digite o preço do Tênis: ");
            double preco = scanner.nextDouble();
            System.out.print("Qual o tamanho do Tênis: ");
            String tamanho = scanner.next();
            System.out.print("Qual a cor do Tênis: ");
            String cor = scanner.next();
            System.out.print("Qual a marca do Tênis: ");
            String marca = scanner.next();
            System.out.print("Digite a categoria do Tênis: ");
            String tipo = scanner.next();

            Produto novoProduto = new Produto(preco, tamanho, cor, marca, tipo, idFornecedor);
            //produtoController.cadastrarProduto(novoProduto);

            System.out.print("Deseja adicionar outro produto? (S/N): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
        } while (true);
    }
    public static void alterarProduto(Fornecedor fornecedor) {
        ProdutoController produtoController = new ProdutoController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            if (fornecedor != null)
                listarProdutosFornecedorMenu(fornecedor, false);
            else
                listarProdutosMenu(false);
            System.out.println("Id do produto que deseja alterar");
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String resposta = scanner.next();

            switch (resposta) {
                case "0":
                    System.out.println("Opção Voltar selecionada.");
                    return;
                default:
                    var produtoEncontrado = produtoController.buscarProduto(Integer.parseInt(resposta));

                    if (produtoEncontrado != null) {
                        menuClear();
                        System.out.println(produtoEncontrado);
                        System.out.println("O que deseja alterar?");
                        System.out.println("1 - Preço");
                        System.out.println("2 - Tamanho");
                        System.out.println("3 - Cor");
                        System.out.println("4 - Marca");
                        System.out.println("5 - Tipo");
                        System.out.println("0 - Voltar");
                        System.out.print("O que deseja? ");
                        String respostaAlteracao = scanner.next();

                        switch (respostaAlteracao) {
                            case "1":
                                System.out.print("Qual o novo preço? ");
                                double novoPreco = scanner.nextDouble();
                                produtoEncontrado.setPreco(novoPreco);
                                break;
                            case "2":
                                System.out.print("Qual o novo tamanho? ");
                                String novoTamanho = scanner.nextLine();
                                produtoEncontrado.setTamanho(novoTamanho);
                                break;
                            case "3":
                                System.out.print("Qual a nova cor? ");
                                String novaCor = scanner.nextLine();
                                produtoEncontrado.setCor(novaCor);
                                break;
                            case "4":
                                System.out.print("Qual a nova marca? ");
                                String novaMarca = scanner.nextLine();
                                produtoEncontrado.setCor(novaMarca);
                                break;
                            case "5":
                                System.out.print("Qual o novo tipo? ");
                                String novoTipo = scanner.nextLine();
                                produtoEncontrado.setTipo(novoTipo);
                                break;
                            case "0":
                                System.out.println("Opção Voltar selecionada.");
                                return;
                            default:
                                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        }
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
            }
        } while (true);
    }
    public static void excluirProduto() {
        ProdutoController produtoController = new ProdutoController();
        FornecedorController fornecedorController = new FornecedorController();
        menuClear();
        Scanner scanner = new Scanner(System.in);
        listarProdutosMenu(false);
        System.out.println("Qual produto você deseja apagar? ");
        String respostaExcluirProduto = scanner.next();

        produtoController.excluirProduto(Integer.parseInt(respostaExcluirProduto));
    }
    public static void listarProdutosFornecedorMenu(Fornecedor fornecedor, boolean Emenu) {
        ProdutoController produtoController = new ProdutoController();
        if(Emenu){
            menuClear();
            Scanner scanner = new Scanner(System.in);
            do {
                for (var produto : produtoController.listarProdutosPorFornecedor(fornecedor.getId())) {
                    System.out.println(produto);
                }
                System.out.println("0 - Voltar");
                System.out.print("O que deseja? ");
                String resposta = scanner.next();
                switch (resposta) {
                    case "0":
                        System.out.println("Opção Voltar selecionada.");
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            } while (true);
        }else {
            for (var produto : produtoController.listarProdutosPorFornecedor(fornecedor.getId())) {
                System.out.println(produto);
            }
        }
    }
    public static void listarProdutosMenu(boolean Emenu) {
        ProdutoController produtoController = new ProdutoController();
        if(Emenu){
            menuClear();
            Scanner scanner = new Scanner(System.in);
            do {
                for (var produto : produtoController.listarProdutos()) {
                    System.out.println(produto);
                }
                System.out.println("0 - Voltar");
                System.out.print("O que deseja? ");
                String resposta = scanner.next();
                switch (resposta) {
                    case "0":
                        System.out.println("Opção Voltar selecionada.");
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            } while (true);
        }else {
            for (var produto : produtoController.listarProdutos()) {
                System.out.println(produto);
            }
        }
    }
    public static void ComprarDoFornecedor() {
        EstoqueController estoqueController = new EstoqueController();
        ProdutoController produtoController = new ProdutoController();
        CompraController compraController = new CompraController();

        Scanner scanner = new Scanner(System.in);
        menuClear();

        while (true) {
            listarProdutosMenu(false);
            System.out.println("Id do produto que deseja comprar");
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String resposta = scanner.next();

            if (resposta.equals("0")) {
                System.out.println("Opção Voltar selecionada.");
                return;
            }

            var produtoEncontrado = produtoController.buscarProduto(Integer.parseInt(resposta));
            if (produtoEncontrado == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            System.out.print("Quantas unidades você deseja? ");
            int quantidadeEscolhida = scanner.nextInt();

            Estoque estoque = new Estoque(quantidadeEscolhida, 0, 999, produtoEncontrado.getId());
            //estoqueController.cadastrarEstoque(estoque);
            //compraController.cadastrarCompra(new Compra(quantidadeEscolhida, produtoEncontrado.getPreco(), new Date(), produtoEncontrado.getId(),produtoEncontrado.getFornecedorId()));
            menuClear();
            System.out.println("Compra realizada.");
        }
    }

    public static void menuVender(){
        EstoqueController estoqueController = new EstoqueController();
        ClienteController clienteController = new ClienteController();
        ProdutoController produtoController = new ProdutoController();
        VendaController vendaController = new VendaController();
        Scanner scanner = new Scanner(System.in);
        do {
            menuClear();
            listarEstoqueMenu();
            System.out.println("Id do produto que deseja vender");
            System.out.println("0 - Voltar");
            System.out.print("O que deseja? ");
            String respostaIdProduto = scanner.next();

            switch (respostaIdProduto) {
                case "0":
                    System.out.println("Opção Voltar selecionada.");
                    return;
                default:
                    int produtoId = Integer.parseInt(respostaIdProduto);
                    Estoque estoqueEncontrado = estoqueController.buscarEstoque(produtoId);

                    if (estoqueEncontrado != null) {
                        Produto produtoEncontrado = produtoController.buscarProduto(estoqueEncontrado.getProdutoId());

                        menuClear();
                        listarClientesMenu(false);
                        do {
                            System.out.println("Id do cliente que deseja comprar o produto");
                            System.out.println("0 - Voltar");
                            System.out.print("O que deseja? ");
                            String respostaIdCliente = scanner.next();

                            switch (respostaIdCliente) {
                                case "0":
                                    System.out.println("Opção Voltar selecionada.");
                                    return;
                                default:
                                    var clienteEncontrado = clienteController.buscarCliente(Integer.parseInt(respostaIdCliente));

                                    if (clienteEncontrado != null) {
                                        System.out.print("Quantas unidades? ");
                                        int quantidadeEscolhida = scanner.nextInt();

                                        menuClear();
                                        var venda = new Venda(quantidadeEscolhida, produtoEncontrado.getPreco(), new Date(), produtoEncontrado.getId(), clienteEncontrado.getId());

                                        if (estoqueEncontrado.getQtd() - quantidadeEscolhida < 0) {
                                            System.out.println("Quantidade insuficiente em estoque");
                                            break;
                                        }

                                        //vendaController.cadastrarVenda(venda);
                                    } else {
                                        System.out.println("Cliente não encontrado.");
                                    }
                            }
                        } while (true);

                    } else {
                        System.out.println("Produto não encontrado.");
                    }
            }
        } while (true);
    }

    public static void listarEstoqueMenu() {
        EstoqueController estoqueController = new EstoqueController();
        for (var estoque : estoqueController.listarEstoque()) {
            System.out.println(estoque);
        }
    }
}
