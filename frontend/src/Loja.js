import React, { useState, useEffect } from 'react';
import ProdutoCard from './ProdutoCard';
import Header from './Header';
import Swal from 'sweetalert2';
import ProdutoCardDB from './ProdutoCardDB';

const Loja = () => {
    const [produtosEstoque, setProdutosEstoque] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/estoque/listarEstoque')
            .then(response => response.json())
            .then(data => setProdutosEstoque(data))
            .catch(error => console.error('Erro ao obter produtos em estoque:', error));
    }, []);

    const [clientes, setClientes] = useState([]);
    const [produto, setProduto] = useState({
        preco: '',
        tamanho: '',
        cor: '',
        marca: '',
        tipo: '',
        fornecedorId: '',
    });

    const buscarProduto = async (produtoId) => {
        const response = await fetch(`http://localhost:8080/produto/buscarProduto/${produtoId}`);
        const data = await response.json();
        setProduto(data);
        return data;
    }

    const buscarClienteId = async () => {
        const response = await fetch('http://localhost:8080/cliente/listarClientes');
        const data = await response.json();
        setClientes(data);
        const idsClientes = data.map(cliente => cliente.id);

        const idsClientesObj = idsClientes.reduce((obj, id, index) => {
            obj[index] = id;
            return obj;
        }, {});

        const { value: index } = await Swal.fire({
            title: 'Qual o Id do Cliente para o qual você deseja vender?',
            input: 'select',
            inputOptions: idsClientes,
            inputPlaceholder: 'Selecione o ID do cliente',
            showCancelButton: true,
            confirmButtonText: 'Selecionar',
            showLoaderOnConfirm: true,
        });

        return idsClientesObj[index];
    };

    const [venda, setVenda] = useState({
        qtd: '',
        valor: '',
        data: '',
        produtoId: '',
        clienteId: '',
    });

    const buscarQuantidadeProduto = async () => {
        const { value: quantidadeProduto } = await Swal.fire({
            title: 'Quantas unidades o seu cliente deseja?',
            input: 'number',
            inputAttributes: {
                min: 1,
                step: 1
            },
            showCancelButton: true,
            confirmButtonText: 'Vender',
            showLoaderOnConfirm: true,

        });

        return quantidadeProduto;
    }

    const cadastrarVenda = async (idCliente, quantidadeProduto, produto) => {
        const venda = {
            qtd: quantidadeProduto,
            valor: produto.preco,
            data: new Date(),
            produtoId: produto.id,
            clienteId: idCliente,
        };

        const response = await fetch('http://localhost:8080/venda/cadastrarVenda', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(venda)
        });

        const data = await response.text();

        if (data === 'false') {
            console.error('Erro ao cadastrar venda:', response);
        } else {
            console.log('Venda cadastrada com sucesso!');
        }
    };

   const realizarVenda = async (produtoId) => {
       const produto = await buscarProduto(produtoId);
       var idCliente = await buscarClienteId();
       var quantidadeProduto = await buscarQuantidadeProduto();

       cadastrarVenda(idCliente, quantidadeProduto, produto);
   };

    return (
        <div>
            <Header />
            <div>
                {produtosEstoque.map(produtoEstoque => (
                    <ProdutoCardDB
                        key={produtoEstoque.produtoId}
                        produtoId={produtoEstoque.produtoId}
                        onComprarClick={() => realizarVenda(produtoEstoque.produtoId)}
                    />
                ))}
            </div>
        </div>
    );
}

export default Loja;
