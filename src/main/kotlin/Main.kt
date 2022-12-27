//this class is using a primary constructor.
class Conta(
    val titular: String,
    val numeroDaConta: Int
) {
    private var saldo: Double = 0.0;

    fun deposita(deposito: Double) {
        this.saldo += deposito;
        println("O valor de $deposito foi depositado na conta de $titular")
    }

    fun saca(saque: Double) {
        when {
            saldo <= 0 -> {
                print("Não é possível sacar de uma conta com saldo menor ou igual a 0.")
            }

            saldo >= saque -> {
                this.saldo -= saque;
                println("O valor de $saque foi sacado na conta de $titular");
            }
        }
    }

    fun transfere(contaSaque: Conta, contadeposito: Conta, valor: Double) {
        when {
            contaSaque.saldo >= valor -> {
                contaSaque.saldo -= valor;
                contadeposito.deposita(valor);
                println("O valor de $valor foi depositado na conta de ${contadeposito.titular}.")
            }

            contaSaque.saldo < valor -> {
                println("A conta $contaSaque não possui saldo suficiente para essa transação.")
            }

            contaSaque.saldo <= 0 -> {
                println("O saldo dessa conta está negativo ou é igual a 0.")
            }
        }
    }

    fun getSaldo() {
        println("Saldo atual de $titular: $saldo");
    }

    fun setSaldo(saldo: Double) {
        if (saldo <= 0) {
            print("O valor do saldo deve ser maior que 0.")
        } else {
            this.saldo = saldo;
        }
    }


}

fun main() {
    var saldo: Double = 0.0;
    val contaRafael = Conta("Rafael", 322);
    contaRafael.deposita(200.0)
    //Outra forma de enviar os parametros para o construtor. Pode ir fora de ordem também.
    val contaCool = Conta( numeroDaConta = 555, titular = "Cool");
    contaCool.deposita(1200.0)
    contaCool.transfere(contaCool, contaRafael, 600.0)
    contaRafael.getSaldo();
    contaCool.getSaldo()
//    printUsers(saldo);
//    print(Conta().titular)
//    val rafael = Conta()
//    val maikon = Conta()
//    maikon.titular = "Maikon";
//    rafael.titular="Rafael";
//    rafael.deposita(200.50);
//    rafael.saca(139.0)
//    rafael.getSaldo();
//    rafael.transfere(rafael, maikon, 49.0)
//    maikon.getSaldo();
}


fun printUsers(saldo: Double) {
    val titular = "Rafael"
    val numConta: Int = 133
    for (i in 5 until 10 step 2) {
        println("Bem-vindo ao ByteBank")
        println("Titular: $titular $i ")
        println("Número da conta $numConta $i \nSaldo: $saldo")

        when {
            saldo > 0 -> {
                print("Saldo positivo.")
            }

            saldo < 0 -> {
                print("Saldo negativo.")
            }

            else -> {
                print("Saldo neutro.")
            }
        }
    }

}

