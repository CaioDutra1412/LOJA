import React, { useState,useEffect } from "react";
import Swal from 'sweetalert2';
import './Fornecedor.css';
import Header from "./Header";

function Fornecedor() {
    const [formData, setFormData] = useState({
        nome: '',
        cpf: '',
        endereco: '',
        sexo: '',
        telefone: '',
        email: '',
        cnpj: '',
        numeroInscricao: '',
        nomeFantasia: '',
        dataDeAbertura: '',
        porte: '',
        atividadeEconomicaPrincipal: '',
        situacaoCadastral: '',
    });

    const [fornecedores, setFornecedores] = useState([]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevState) => ({ ...prevState, [name]: value }));
    };

    const cadastrarFornecedor = async () => {
        try {
            const response = await fetch('http://localhost:8080/fornecedor/cadastrarFornecedor', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });
            if (response.ok) {
                Swal.fire('Fornecedor Cadastrado!', 'O fornecedor foi cadastrado com sucesso.', 'success')
                buscarFornecedores();
            } else {
                alert('Erro ao cadastrar Fornecedor');
            }
        } catch (error) {
            console.error('Erro ao cadastrar Fornecedor:', error);
        }
    };

    const buscarFornecedores = () => {
        fetch('http://localhost:8080/fornecedor/listarFornecedores')
            .then(response => response.json())
            .then(data => setFornecedores(data))
            .catch(error => console.error('Erro ao buscar fornecedores:', error));
    };

    useEffect(() => {
        buscarFornecedores();
    }, []);

    const confirmarExclusao = (id) => {
        Swal.fire({
            title: 'Você realmente deseja excluir este fornecedor?',
            showDenyButton: true,
            confirmButtonText: `Sim`,
            denyButtonText: `Não`,
        }).then((result) => {
            if (result.isConfirmed) {
                fetch(`http://localhost:8080/fornecedor/excluirFornecedor/${id}`, {
                    method: 'GET',
                })
                .then(response => response.text())
                .then(data => {
                    if (data === 'false') {
                        fetch(`http://localhost:8080/produto/listarProdutosPorFornecedor/${id}`)
                        .then(response => response.json())
                        .then(produtos => {
                            let produtosStr = produtos.map(produto => produto.id).join(', ');
                            Swal.fire({
                                icon: 'error',
                                title: 'Erro ao excluir',
                                text: `Não é possível excluir o fornecedor pois ele tem produtos associados: IDs [ ${produtosStr} ]`,
                            });
                        })
                        .catch((error) => {
                            console.error('Erro:', error);
                        });
                    } else {
                        console.log('Fornecedor excluído:', id);
                        buscarFornecedores();
                    }
                })
                .catch((error) => {
                    console.error('Erro:', error);
                });
            }
        })
    };

    return (
        <div>
            <Header/>
            <h3>Cadastro Fornecedor</h3>

            <div className="formulario">
                <div>
                    <h3>Dados Vendedor</h3>
                <div>
                    <label>Nome: </label>
                    <input
                        type="text"
                        name="nome"
                        value={formData.nome}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>CPF: </label>
                    <input
                        type="text"
                        name="cpf"
                        value={formData.cpf}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Endereço: </label>
                    <input
                        type="text"
                        name="endereco"
                        value={formData.endereco}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Sexo: </label>
                    <input
                        type="text"
                        name="sexo"
                        value={formData.sexo}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Telefone: </label>
                    <input
                        type="text"
                        name="telefone"
                        value={formData.telefone}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Email: </label>
                    <input
                        type="text"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                    />
                </div>
            </div>

            <div>
                <h3>Dados Empresa</h3>
                <div>
                    <label>CNPJ: </label>
                    <input
                        type="text"
                        name="cnpj"
                        value={formData.cnpj}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Numero Inscrição: </label>
                    <input
                        type="text"
                        name="numeroInscricao"
                        value={formData.numeroInscricao}
                        onChange={handleChange}
                    />
                </div>
                <div>
                      <label>Nome Fantasia: </label>
                      <input
                          type="text"
                          name="nomeFantasia"
                          value={formData.nomeFantasia}
                          onChange={handleChange}
                      />
                </div>
                <div>
                    <label>Data de Abertura: </label>
                    <input
                        type="text"
                        name="dataDeAbertura"
                        value={formData.dataDeAbertura}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Porte: </label>
                    <input
                        type="text"
                        name="porte"
                        value={formData.porte}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Atividade Econômica Principal: </label>
                    <input
                        type="text"
                        name="atividadeEconomicaPrincipal"
                        value={formData.atividadeEconomicaPrincipal}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Situação Cadastral: </label>
                    <input
                        type="text"
                        name="situacaoCadastral"
                        value={formData.situacaoCadastral}
                        onChange={handleChange}
                    />
                </div>
            </div>
            </div>

            <div>
                <button onClick={cadastrarFornecedor}>Cadastrar</button>
            </div>
            <table class="tabela-fornecedores" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CNPJ</th>
                        <th>Numero de Inscrição</th>
                        <th>Nome Fantasia</th>
                        <th>Data de abertura</th>
                        <th>Porte</th>
                        <th>Atividade Econômica Principal</th>
                        <th>Situacao Cadastral</th>
                    </tr>
                </thead>
                <tbody>
                    {fornecedores.map(fornecedor => (
                        <tr key={fornecedor.id} onClick={() => confirmarExclusao(fornecedor.id)}>
                            <td>{fornecedor.id}</td>
                            <td>{fornecedor.nome}</td>
                            <td>{fornecedor.cnpj}</td>
                            <td>{fornecedor.numeroInscricao}</td>
                            <td>{fornecedor.nomeFantasia}</td>
                            <td>{fornecedor.dataDeAbertura}</td>
                            <td>{fornecedor.porte}</td>
                            <td>{fornecedor.atividadeEconomicaPrincipal}</td>
                            <td>{fornecedor.situacaoCadastral}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Fornecedor;
