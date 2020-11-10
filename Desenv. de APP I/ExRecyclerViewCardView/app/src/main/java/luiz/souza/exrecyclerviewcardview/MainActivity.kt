package luiz.souza.exrecyclerviewcardview

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import luiz.souza.exrecyclerviewcardview.adapters.ClientAdapter
import luiz.souza.exrecyclerviewcardview.dao.AppDatabase
import luiz.souza.exrecyclerviewcardview.dao.ClientDAO
import luiz.souza.exrecyclerviewcardview.extensions.toast
import luiz.souza.exrecyclerviewcardview.model.Client

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ClientAdapter
    private var clients = arrayListOf<Client>()

//    private lateinit var clientDAO: ClientDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = AppDatabase.openDatabase(this@MainActivity)

        val clients : List<Client> = database!!.clientDAO().fetch()
        initializer(clients)


        //Setando o adapter
        adapter = ClientAdapter(clients, this@MainActivity, {client: Client -> resultItemClicked(client)})
        recyclerViewClients.adapter = adapter
        //Setando o gerenciador de layout do recyclerview
        recyclerViewClients.layoutManager = LinearLayoutManager(this@MainActivity)


        buttonOK.setOnClickListener {
            var client = Client(
                null,
                editTextName.text.toString(),
                editTextGender.text.toString(),
                editTextIncome.text.toString().toDouble())

            this.clients.add(client) // salvando no array

            database!!.clientDAO().store(client)

//            this.clientDAO.store(client) //salvando no banco!

            adapter.notifyInsertedItemList()

            toast("Cliente cadastrado com sucesso!")
        }

//        val clientt = Client(1,"a", "a", 2000.99)
//        if(this.clientDAO.delete(clientt)) toast("excluiu com sucesso!") else toast("erro ao excluir")
//
//        val clienttt = Client(1,"a", "a", 2000.88)
//        this.clientDAO.update(clienttt)

    }

    override fun onPause() {
        super.onPause()
//        clientDAO.closeDatabase()
    }

    override fun onRestart() {
        super.onRestart()
//        clientDAO.openDatabaseWritable()
    }

    private fun resultItemClicked(client: Client) {
        toast("Você clicou em: ${client.toString()}")
        Log.d("tag clicou", "tag clicou result ma")

        val dialogBuilder = AlertDialog.Builder(this@MainActivity)

        val alert = dialogBuilder
            .setTitle("Atenção")
            .setCancelable(false)
            .setMessage("Excluir ou ir para a próxima tela?")
            .setPositiveButton("Excluir", DialogInterface.OnClickListener() {
                    dialog, id ->

              //alterar
                val client1 = Client(10, "xxx", "xxx", 123312.12)
//                this.client.DAO.update(client1)
                this.adapter.notifyDataChanged() //notifiquei o adapter sobre a mudança
                toast("alteradp com sucesso")
            })
            .setNegativeButton("Ir para próxima tela", DialogInterface.OnClickListener() {
                    dialog, id ->

                //programacao... se ele clicar no proxima tela
                val intent = Intent(this@MainActivity, ClientDetail::class.java)
                intent.putExtra("client", client)
                startActivity(intent)

            }).create()

        alert.show()


    }

    private fun initializer(clients: List<Client>) {

//        this.clientDAO = ClientDAO(this@MainActivity)
//        this.clientDAO.openDatabaseWritable()

//        this.clients = this.clientDAO.fetchClients() as ArrayList<Client> //cast

        //Setando o adapter
        adapter = ClientAdapter(clients, this@MainActivity, {client: Client -> resultItemClicked(client)})
        recyclerViewClients.adapter = adapter

        //Setando o gerenciador de layout do recyclerview
        recyclerViewClients.layoutManager = LinearLayoutManager(this@MainActivity)
//        recyclerViewClients.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

}