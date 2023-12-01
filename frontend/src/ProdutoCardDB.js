import React, { useEffect, useState } from 'react';
import './ProdutoCard.css';

const ProdutoCard = ({ produtoId, onComprarClick }) => {
    const [produto, setProduto] = useState({});

    useEffect(() => {
        fetch(`http://localhost:8080/produto/buscarProduto/${produtoId}`)
            .then(response => response.json())
            .then(data => setProduto(data))
            .catch(error => console.error('Erro ao buscar produto:', error));
    }, [produtoId]);

    return (
        <div className="produto-card">
            <h3>{produto.marca}</h3>
            <p><strong>Tipo:</strong> {produto.tipo}</p>
            <p><strong>Cor:</strong> {produto.cor}</p>
            <p><strong>Valor:</strong>  R$ {produto.preco?.toFixed(2)}</p>
            <button onClick={onComprarClick}>Vender</button>
        </div>
    );
}

export default ProdutoCard;