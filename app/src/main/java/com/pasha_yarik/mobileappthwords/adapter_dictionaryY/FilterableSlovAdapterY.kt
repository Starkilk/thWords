package com.pasha_yarik.mobileappthwords.adapter_dictionaryY

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.pasha_yarik.mobileappthwords.R
import java.util.Locale

class FilterableSlovAdapterY (private val originalList: List<SlovDataModelY>) :
    RecyclerView.Adapter<SlovAdapterY.SlovHolder>(), Filterable {

    private var filteredList = originalList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlovAdapterY.SlovHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slov_list_item_y, parent, false)
        return SlovAdapterY.SlovHolder(view)
    }

    override fun onBindViewHolder(holder: SlovAdapterY.SlovHolder, position: Int) {
        holder.setData(filteredList[position])
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint.toString().lowercase(Locale.getDefault())
                filteredList = if (query.isEmpty()) {
                    originalList
                } else {
                    originalList.filter { slov ->
                        slov.EnglishWord.lowercase(Locale.getDefault()).contains(query) ||
                                slov.RussianWord.lowercase(Locale.getDefault()).contains(query)
                    }
                }
                val results = FilterResults()
                results.values = filteredList
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<SlovDataModelY>
                notifyDataSetChanged()
            }

        }
    }

}