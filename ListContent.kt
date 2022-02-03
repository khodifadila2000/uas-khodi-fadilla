package com.informatika19100066.khodifadila.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.informatika19100066.khodifadila.UpdateDataActivity
import retrofit2.Callback

class R {

}

class ListContent(val ldata : List<DataItem?>?, val context: Context, val kondisi : String) :
    ListContent.RecyclerView.Adapter<ListContent.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        val hari = view.findViewById<TextView>(R.id.tv_hari)
        val jammulai = view.findViewById<TextView>(R.id.tv_jammulai)
        val jamberhenti  = view.findViewById<TextView>(R.id.tv_jamberhenti)
        val editBarang = view.findViewById<TextView>(R.id.tv_edit)
        val deleteBarang = view.findViewById<TextView>(R.id.tv_delete)

    }

    class RecyclerView {
        open class ViewHolder(value: View) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_hari, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return ldata!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = ldata?.get(position)
        holder.editBarang.setOnClickListener {
            val i = Intent(context, UpdateDataActivity::class.java)
            i.putExtra("hari", model?.hari)
            i.putExtra("jammulai", model?.jammulai)
            i.putExtra("jamberhenti", model?.jamberhenti)
            context.startActivity(i)
        }
        holder.deleteBarang.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle("Delete" + model?.hari)
                .setMessage("Apakah Anda Ingin Mengahapus Data Ini?")
                .setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->

                    val koneksi =

                    koneksi.service.deleteBarang(model?.id).enqueue(object :
                        Callback<responactioninfak> {
                        override fun onFailure(call: Call<responactioninfak>, t: Throwable) {
                            Log.d("pesan1", t.localizedMessage)
                        }

                        override fun onResponse(
                            call: Call<responactioninfak>,
                            response: Response<responactioninfak>
                        ) {
                            if(response.isSuccessful){
                                Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_LONG).show()
                                notifyDataSetChanged()
                                notifyItemRemoved(position)
                                notifyItemChanged(position)
                                notifyItemRangeChanged(position, ldata!!.size)

                                if(kondisi == " InsertDataActivity"){
                                    val activity = (context as InsertDataActivity)
                                    activity.getData()
                                }else if(kondisi == " UpdateDataActivity"){
                                    val activity = (context as UpdateDataActivity)
                                    activity.getData()
                                }else{
                                    val activity = (context as MainActivity)
                                    activity.getData()

                                }
                                Log.d("bpesan", response.body().toString())

                            }
                        }
                    })
                })
                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.cancel()
                })
                .show()
        }
    }

    class responactioninfak {

    }

    class DataItem {

        val id: Any

    }


}
