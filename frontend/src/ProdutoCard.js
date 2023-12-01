import React from 'react';
import './ProdutoCard.css';

const ProdutoCard = ({ nome, valor, onComprarClick }) => {
    return (
        <div className="produto-card">
            <h3>{nome}</h3>
            <p>Valor: R$ {valor.toFixed(2)}</p>
            <button onClick={onComprarClick}>Comprar</button>
        </div>
    );
}

export default ProdutoCard;
