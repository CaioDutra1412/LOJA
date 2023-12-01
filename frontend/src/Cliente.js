import React, { useState, useEffect } from "react";
import Swal from 'sweetalert2';
import './Cliente.css';
import Header from "./Header";

function Cliente() {
    const [formData, setFormData] = useState({
        nome: '',
        cpf: '',
        endereco: '',
        sexo: '',
        telefone: '',
        email: '',
        status: '',
    });

    const [clientes, setClientes] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/cliente/listarClientes')
            .then(response => response.json())
            .then(data => setClientes(data))
            .catch(error => console.error('Erro ao buscar clientes:', error));
    }, []);

    const buscarClientes = () => {
        fetch('http://localhost:8080/cliente/listarClientes')
            .then(response => response.json())
            .then(data => setClientes(data))
            .catch(error => console.error('Erro ao buscar clientes:', error));
    };

    useEffect(() => {
        buscarClientes();
    }, []);

    const cadastrarCliente = async () => {
        try {
            const response = await fetch('http://localhost:8080/cliente/cadastrarCliente', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });
            if (response.ok) {
                Swal.fire('Cliente Cadastrado!', 'O cliente foi cadastrado com sucesso.', 'success')
                buscarClientes();
            } else {
                alert('Erro ao cadastrar Cliente');
            }
        } catch (error) {
            console.error('Erro ao cadastrar Cliente:', error);
        }
    };

    const confirmarExclusao = (id) => {
        Swal.fire({
            title: 'Você realmente deseja excluir este usuário?',
            showDenyButton: true,
            confirmButtonText: `Sim`,
            denyButtonText: `Não`,
        }).then((result) => {
            if (result.isConfirmed) {
                fetch(`http://localhost:8080/cliente/excluirCliente/${id}`, {
                    method: 'GET',
                })
                .then(response => response.json())
                .then(data => {
                    console.log('Usuário excluído:', id);
                    buscarClientes();
                })
                .catch((error) => {
                    console.error('Erro:', error);
                });
            }
        })
    };

    return (
        <div>
            <div>
                <Header />
                <h3>Cadastro Cliente</h3>
                <div>
                    <label>Nome: </label>
                    <input
                        type="text"
                        id="component"
                        value={formData.nome}
                        onChange={(e) =>
                            setFormData((prevState) => ({
                                ...prevState,
                                nome: e.target.value,
                            }))
                        }
                    />
                </div>
                <div>
                    <label>CPF: </label>
                    <input
                        type="text"
                        id="component"
                        value={formData.cpf}
                        onChange={(e) =>
                            setFormData((prevState) => ({
                                ...prevState,
                                cpf: e.target.value,
                            }))
                        }
                    />
                </div>
                <div>
                    <label>Endereço: </label>
                    <input
                        type="text"
                        id="component"
                        value={formData.endereco}
                        onChange={(e) =>
                            setFormData((prevState) => ({
                                ...prevState,
                                endereco: e.target.value,
                            }))
                        }
                    />
                </div>
                <div>
                    <label>Sexo: </label>
                    <input
                        type="text"
                        id="component"
                        value={formData.sexo}
                        onChange={(e) =>
                            setFormData((prevState) => ({
                                ...prevState,
                                sexo: e.target.value,
                            }))
                        }
                    />
                </div>
                <div>
                    <label>Telefone: </label>
                    <input
                        type="text"
                        id="component"
                        value={formData.telefone}
                        onChange={(e) =>
                            setFormData((prevState) => ({
                                ...prevState,
                                telefone: e.target.value,
                            }))
                        }
                    />
                </div>
                <div>
                    <label>Email: </label>
                    <input
                        type="text"
                        id="component"
                        value={formData.email}
                        onChange={(e) =>
                            setFormData((prevState) => ({
                                ...prevState,
                                email: e.target.value,
                            }))
                        }
                    />
                </div>
                <div>
                    <label>Status: </label>
                    <input
                        type="text"
                        id="component"
                        value={formData.status}
                        onChange={(e) =>
                            setFormData((prevState) => ({
                                ...prevState,
                                status: e.target.value,
                            }))
                        }
                    />
                </div>
                <div>
                    <button onClick={cadastrarCliente}>Cadastrar</button>
                </div>
            </div>

            <table class="tabela-clientes" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Endereço</th>
                        <th>Sexo</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {clientes.map(cliente => (
                        <tr key={cliente.id} onClick={() => confirmarExclusao(cliente.id)}>
                            <td>{cliente.id}</td>
                            <td>{cliente.nome}</td>
                            <td>{cliente.cpf}</td>
                            <td>{cliente.endereco}</td>
                            <td>{cliente.sexo}</td>
                            <td>{cliente.telefone}</td>
                            <td>{cliente.email}</td>
                            <td>{cliente.status}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Cliente;
