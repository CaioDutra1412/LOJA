import React, { useState,useEffect } from "react";
import Swal from 'sweetalert2';
import './Estoque.css';
import Header from "./Header";

function Estoque() {
    const [formData, setFormData] = useState({
        preco: '',
        tamanho: '',
        cor: '',
        marca: '',
        tipo: '',
        fornecedorId: '',
    });

    const [formCompra, setFormCompra] = useState({
        qtd: '',
        preco: '',
        data: '',
        produtoId: '',
        fornecedorId: '',
    });

    const [produtos, setProdutos] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/produto/listarProdutos')
            .then(response => response.json())
            .then(data => setProdutos(data))
            .catch(error => console.error('Erro ao buscar produtos:', error));
    }, []);

    const buscarProdutos = () => {
        fetch('http://localhost:8080/produto/listarProdutos')
            .then(response => response.json())
            .then(data => setProdutos(data))
            .catch(error => console.error('Erro ao buscar Produtos:', error));
    };


    const [estoques, setEstoques] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/estoque/listarEstoque')
            .then(response => response.json())
            .then(data => setEstoques(data))
            .catch(error => console.error('Erro ao buscar Estoques:', error));
    }, []);

    const buscarEstoques = () => {
        fetch('http://localhost:8080/estoque/listarEstoque')
            .then(response => response.json())
            .then(data => setEstoques(data))
            .catch(error => console.error('Erro ao buscar Estoques:', error));
    };


    const confirmarCompra = (produtoId, produtoPreco, fornecedorId) => {
        Swal.fire({
            title: 'Quantos produtos você deseja comprar?',
            input: 'number',
            inputAttributes: {
                min: 1,
                step: 1
            },
            showCancelButton: true,
            confirmButtonText: 'Comprar',
            showLoaderOnConfirm: true,
            preConfirm: (quantidade) => {
                formCompra.qtd = quantidade;
                formCompra.preco = produtoPreco;
                formCompra.produtoId = produtoId;
                formCompra.fornecedorId = fornecedorId;
                formCompra.data = new Date();
                return fetch('http://localhost:8080/compra/cadastrarCompra', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(formCompra),
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(response.statusText)
                    }
                    return response.text().then(text => text ? JSON.parse(text) : {})
                })
                .catch(error => {
                    Swal.showValidationMessage(`Erro: ${error}`)
                })
            },
            allowOutsideClick: () => !Swal.isLoading()
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire('Compra realizada!', 'Seu produto foi comprado com sucesso.', 'success')
                buscarEstoques();
            }
        })
    };

    return (
        <div>
            <Header/>
            <h3>Catalogo de produtos disponíveis</h3>

            <table className="tabela-produtos" >
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
                        <tr key={produto.id} onClick={() => confirmarCompra(produto.id, produto.preco, produto.fornecedorId)}>
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

            <h3>Produtos em estoque</h3>
            <table className="tabela-produtos" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Quantidade</th>
                        <th>ProdutoID</th>
                    </tr>
                </thead>
                <tbody>
                    {estoques.map(estoque => (
                        <tr key={estoque.id}>
                            <td>{estoque.id}</td>
                            <td>{estoque.qtd}</td>
                            <td>{estoque.produtoId}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Estoque;
