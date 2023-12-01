import React, { useState, useEffect } from "react";
import Swal from 'sweetalert2';
import './Produto.css';
import Header from "./Header";

function Produto() {
    const [formData, setFormData] = useState({
        preco: '',
        tamanho: '',
        cor: '',
        marca: '',
        tipo: '',
        fornecedorId: '',
    });

    const [produtos, setProdutos] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/produto/listarProdutos')
            .then(response => response.json())
            .then(data => setProdutos(data))
            .catch(error => console.error('Erro ao buscar produtos:', error));
    }, []);

    const cadastrarProduto = async () => {
        try {
            const response = await fetch('http://localhost:8080/produto/cadastrarProduto', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });
            if (response.ok) {
                Swal.fire('Cadastro realizado!', 'O produto foi cadastrado no catalogo com sucesso.', 'success')
            } else {
                alert('Erro ao cadastrar Produto');
            }
        } catch (error) {
            console.error('Erro ao cadastrar Produto:', error);
        }
    };

    const buscarProdutos = () => {
        fetch('http://localhost:8080/produto/listarProdutos')
            .then(response => response.json())
            .then(data => setProdutos(data))
            .catch(error => console.error('Erro ao buscar Produtos:', error));
    };

    useEffect(() => {
        buscarProdutos();
    }, []);

    const confirmarExclusao = (id) => {
        Swal.fire({
            title: 'Você realmente deseja excluir este produto?',
            showDenyButton: true,
            confirmButtonText: `Sim`,
            denyButtonText: `Não`,
        }).then((result) => {
            if (result.isConfirmed) {
                fetch(`http://localhost:8080/produto/excluirProduto/${id}`, {
                    method: 'GET',
                })
                .then(response => response.json())
                .then(data => {
                    Swal.fire('Produto excluído!', 'Seu produto foi excluido com sucesso.', 'success')
                    buscarProdutos();
                })
                .catch((error) => {
                    console.error('Erro:', error);
                });
            }
        })
    };

    const [fornecedores, setFornecedores] = useState([]);

    const buscarFornecedorId = async () => {
        const response = await fetch('http://localhost:8080/fornecedor/listarFornecedores');
        const data = await response.json();
        setFornecedores(data);
    };

    return (
        <div>
            <Header />
            <h3>Cadastro Produto</h3>
            <div>
                <label>Preço: </label>
                <input
                    type="text"
                    id="component"
                    value={formData.preco}
                    onChange={(e) =>
                        setFormData((prevState) => ({
                            ...prevState,
                            preco: e.target.value,
                        }))
                    }
                />
            </div>
            <div>
                <label>Tamanho: </label>
                <input
                    type="text"
                    id="component"
                    value={formData.tamanho}
                    onChange={(e) =>
                        setFormData((prevState) => ({
                            ...prevState,
                            tamanho: e.target.value,
                        }))
                    }
                />
            </div>
            <div>
                <label>Cor: </label>
                <input
                    type="text"
                    id="component"
                    value={formData.cor}
                    onChange={(e) =>
                        setFormData((prevState) => ({
                            ...prevState,
                            cor: e.target.value,
                        }))
                    }
                />
            </div>
            <div>
                <label>Marca: </label>
                <input
                    type="text"
                    id="component"
                    value={formData.marca}
                    onChange={(e) =>
                        setFormData((prevState) => ({
                            ...prevState,
                            marca: e.target.value,
                        }))
                    }
                />
            </div>
            <div>
                <label>Tipo: </label>
                <input
                    type="text"
                    id="component"
                    value={formData.tipo}
                    onChange={(e) =>
                        setFormData((prevState) => ({
                            ...prevState,
                            tipo: e.target.value,
                        }))
                    }
                />
            </div>
            <div>
                <label>IDFornecedor: </label>
                <select
                    id="component"
                    value={formData.fornecedorId}
                    onClick={buscarFornecedorId}
                    onChange={(e) =>
                        setFormData((prevState) => ({
                            ...prevState,
                            fornecedorId: e.target.value,
                        }))
                    }
                >
                    {fornecedores.map((fornecedor) => (
                        <option key={fornecedor.id} value={fornecedor.id}>
                            {fornecedor.id}
                        </option>
                    ))}
                </select>
            </div>
            <div>
                <button onClick={cadastrarProduto}>Cadastrar</button>
            </div>

            <table class="tabela-produtos" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Preço</th>
                        <th>Tamanho</th>
                        <th>Cor</th>
                        <th>Marca</th>
                        <th>Tipo</th>
                        <th>IDFornecedor</th>
                    </tr>
                </thead>
                <tbody>
                    {produtos.map(produto => (
                        <tr key={produto.id} onClick={() => confirmarExclusao(produto.id)}>
                            <td>{produto.id}</td>
                            <td>{produto.preco}</td>
                            <td>{produto.tamanho}</td>
                            <td>{produto.cor}</td>
                            <td>{produto.marca}</td>
                            <td>{produto.tipo}</td>
                            <td>{produto.fornecedorId}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Produto;
