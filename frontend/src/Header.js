import React from "react";
import { Link } from "react-router-dom";
import "./Header.css";

function Header() {
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/cliente">Cliente</Link>
                    </li>
                    <li>
                        <Link to="/">Fornecedor</Link>
                    </li>
                    <li>
                        <Link to="/produto">Produto</Link>
                    </li>
                    <li>
                        <Link to="/estoque">Estoque</Link>
                    </li>
                    <li>
                        <Link to="/historico">Historico</Link>
                    </li>
                    <li>
                        <Link to="/loja">Loja</Link>
                    </li>
                </ul>
            </nav>
        </div>
    );
}

export default Header;
