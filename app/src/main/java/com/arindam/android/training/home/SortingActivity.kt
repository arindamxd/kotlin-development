package com.arindam.android.training.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.arindam.android.training.R
import com.arindam.android.training.kotlin.sorting.RecentSearch

/**
 * Created by Arindam Karmakar on 29/7/19.
 */

class SortingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchList = listOf(
                RecentSearch(2, "dog"),
                RecentSearch(0, "harry"),
                RecentSearch(1, "car"),
                RecentSearch(3, "android")
        )

        // Mutable Live Data
        val searchMutableLiveData = MutableLiveData<List<RecentSearch>>()
        searchMutableLiveData.value = searchList


        // Sort By
        val sortByList = searchMutableLiveData.value?.sortedBy { it.name }
        val sortByLiveDataList: LiveData<List<RecentSearch>> = Transformations.switchMap(searchMutableLiveData) {
            list -> getCustomList(list)
        }


        // Sorted By Descending
        val sortedByDescendingList = searchMutableLiveData.value?.sortedByDescending { it.id }
        val sortedByDescendingLiveDataList: LiveData<List<RecentSearch>> = Transformations.map(searchMutableLiveData) { it.sortedByDescending { item -> item.id } }


        // Sorted With
        val sortedWithList = searchMutableLiveData.value?.sortedWith(
                Comparator { a, b ->
                    when {
                        a.id > b.id -> 1
                        a.id < b.id -> -1
                        else -> 0
                    }
                }
        )
        val sortedWithLiveDataList: LiveData<List<RecentSearch>> = Transformations.map(searchMutableLiveData) {
            it.sortedWith(
                    Comparator { a, b ->
                        when {
                            a.id > b.id -> 1
                            a.id < b.id -> -1
                            else -> 0
                        }
                    }
            )
        }


        // Sorted Set
        val sortedSetList = searchMutableLiveData.value?.toSortedSet(
                Comparator { a, b ->
                    when {
                        a.id > b.id -> 1
                        a.id < b.id -> -1
                        else -> 0
                    }
                }
        )


        // Outputs
        Log.e("Sort By", sortByList.toString())
        // > [RecentSearch(id=3, name=android), RecentSearch(id=1, name=car), RecentSearch(id=2, name=dog), RecentSearch(id=0, name=harry)]

        Log.e("Sorted By Descending", sortedByDescendingList.toString())
        // > [RecentSearch(id=3, name=android), RecentSearch(id=2, name=dog), RecentSearch(id=1, name=car), RecentSearch(id=0, name=harry)]

        Log.e("Sorted With", sortedWithList.toString())
        // > [RecentSearch(id=0, name=harry), RecentSearch(id=1, name=car), RecentSearch(id=2, name=dog), RecentSearch(id=3, name=android)]

        Log.e("Sorted Set", sortedSetList.toString())


        // Observe Live Data
        sortByLiveDataList.observe(this, Observer {
            Log.e("LiveData", "Sort By: $it")
            // > [RecentSearch(id=3, name=android), RecentSearch(id=1, name=car), RecentSearch(id=2, name=dog), RecentSearch(id=0, name=harry)]
        })
        sortedByDescendingLiveDataList.observe(this, Observer {
            Log.e("LiveData", "Sorted By Descending: $it")
            // > [RecentSearch(id=3, name=android), RecentSearch(id=2, name=dog), RecentSearch(id=1, name=car), RecentSearch(id=0, name=harry)]
        })
        sortedWithLiveDataList.observe(this, Observer {
            Log.e("LiveData", "Sorted With: $it")
            // > [RecentSearch(id=0, name=harry), RecentSearch(id=1, name=car), RecentSearch(id=2, name=dog), RecentSearch(id=3, name=android)]
        })
    }

    private fun getCustomList(list: List<RecentSearch>): LiveData<List<RecentSearch>> {
        val n = MutableLiveData<List<RecentSearch>>()

        for(item in list.listIterator()) {
            val index = list.indexOf(item)
            println(index)

            if (index == 1) {
                item.name = "arindam"
            }

            if (index == 0 && item.id == 2) {
                item.name = "cat"
            }
        }

        n.value = list
        return n
    }

    override fun onDestroy() {
        super.onDestroy()

        // NOTE: Don't forget to remove Live Data Observer
    }
}
