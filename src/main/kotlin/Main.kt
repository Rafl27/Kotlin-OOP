class Conta {
    var titular = "";
    var numeroDaConta:Int = 0;
    var saldo:Double = 0.0;

    fun deposita (deposito:Double) {
        this.saldo += deposito;
        println("O valor de $deposito foi depositado na conta de $titular")
    }

    fun saca (saque:Double){
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

    fun transfere (contaSaque: Conta, contadeposito:Conta, valor:Double ){
        when {
            contaSaque.saldo >= valor -> {
                contaSaque.saldo -= valor;
                contadeposito.saldo += valor;
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

    fun getSaldo () {
        println("Saldo atual de $titular: $saldo");
    }
}

fun main() {
    var saldo: Double = 0.0;
//    printUsers(saldo);
//    print(Conta().titular)
    val rafael = Conta()
    val maikon = Conta()
    maikon.titular = "Maikon";
    rafael.titular="Rafael";
    rafael.deposita(200.50);
    rafael.saca(139.0)
    rafael.getSaldo();
    rafael.transfere(rafael, maikon, 49.0)
    maikon.getSaldo();
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

