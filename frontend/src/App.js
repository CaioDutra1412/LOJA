import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Cliente from "./Cliente";
import Fornecedor from "./Fornecedor";
import Produto from "./Produto";
import Loja from "./Loja";
import Estoque from "./Estoque";
import Historico from "./Historico";


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/cliente" element={<Cliente />} />
        <Route path="/" element={<Fornecedor />} />
        <Route path="/produto" element={<Produto />} />
        <Route path="/loja" element={<Loja />} />
        <Route path="/estoque" element={<Estoque />} />
        <Route path="/historico" element={<Historico />} />
      </Routes>
    </Router>
  );
}

export default App;
