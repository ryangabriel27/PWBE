function verificarSenhas() {
    var senha = document.getElementById("senha").value;
    var confirmarSenha = document.getElementById("confirmarSenha").value;

    // Verifica se as senhas são iguais
    if (senha != confirmarSenha) {
        // Se as senhas não coincidirem, exibe uma mensagem de erro
        alert("As senhas não coincidem. Por favor, digite novamente.");
        return false; // Impede o envio do formulário
    }
    return true; // Permite o envio do formulário se as senhas coincidirem
}

function formatar(mascara, documento) {
    let i = documento.value.length;
    let saida = '#';
    let texto = mascara.substring(i);
    while (texto.substring(0, 1) != saida && texto.length) {
        documento.value += texto.substring(0, 1);
        i++;
        texto = mascara.substring(i);
    }
}