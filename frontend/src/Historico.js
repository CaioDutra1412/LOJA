import React, { useState,useEffect } from "react";
import Swal from 'sweetalert2';
import './Estoque.css';
import Header from "./Header";

function Historico() {
    const [compras, setCompras] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/compra/listarCompras')
            .then(response => response.json())
            .then(data => setCompras(data))
            .catch(error => console.error('Erro ao buscar Compras:', error));
    }, []);

    const buscarProdutos = () => {
        fetch('http://localhost:8080/compra/listarCompras')
            .then(response => response.json())
            .then(data => setCompras(data))
            .catch(error => console.error('Erro ao buscar Compras:', error));
    };


    const [vendas, setVendas] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/venda/listarVendas')
            .then(response => response.json())
            .then(data => setVendas(data))
            .catch(error => console.error('Erro ao buscar Vendas:', error));
    }, []);

    const buscarEstoques = () => {
        fetch('http://localhost:8080/venda/listarVendas')
            .then(response => response.json())
            .then(data => setVendas(data))
            .catch(error => console.error('Erro ao buscar Vendas:', error));
    };

    return (
        <div>
            <Header/>
            <h3>Compras</h3>

            <table className="tabela-produtos" >
                <thead>
                    <tr>
                        <th>Compra Id</th>
                        <th>Produto Id</th>
                        <th>Fornecedor Id</th>
                        <th>Quantidade</th>
                        <th>Valor</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                    {compras.map(compra => (
                        <tr key={compra.id}>
                            <td>{compra.id}</td>
                            <td>{compra.produtoId}</td>
                            <td>{compra.fornecedorId}</td>
                            <td>{compra.qtd}</td>
                            <td>{compra.valor}</td>
                            <td>{compra.data}</td>
                        </tr>
                    ))}
                </tbody>
            </table>

            <h3>Vendas</h3>
            <table className="tabela-produtos" >
                <thead>
                    <tr>
                        <th>Venda Id</th>
                        <th>ProdutoId</th>
                        <th>ClienteId</th>
                        <th>Quantidade</th>
                        <th>Valor</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                    {vendas.map(venda => (
                        <tr key={venda.id}>
                        <td>{venda.id}</td>
                        <td>{venda.produtoId}</td>
                        <td>{venda.clienteId}</td>
                        <td>{venda.qtd}</td>
                        <td>{venda.valor}</td>
                        <td>{venda.data}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Historico;
