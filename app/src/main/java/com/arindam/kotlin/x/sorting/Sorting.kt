package com.arindam.kotlin.x.sorting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

/**
 * Created by Arindam Karmakar on 29/7/19.
 */

data class RecentSearch(
        val id: Int = 0,
        var name: String = String()
)

fun main() {

    val searchList = listOf(
            RecentSearch(0, "harry"),
            RecentSearch(1, "car"),
            RecentSearch(2, "dog")
    )

    // Mutable Live Data
    val searchMutableLiveData = MutableLiveData<List<RecentSearch>>()
    searchMutableLiveData.value = searchList


    // Sort By
    val sortByList = searchMutableLiveData.value?.sortedBy { it.name }
    val sortByLiveDataList: LiveData<List<RecentSearch>> = Transformations.map(searchMutableLiveData) { it.sortedBy { item -> item.name } }


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


    println(sortByList) // > [RecentSearch(id=1, name=car), RecentSearch(id=2, name=dog), RecentSearch(id=0, name=harry)]
    println(sortedByDescendingList) // > [RecentSearch(id=2, name=dog), RecentSearch(id=1, name=car), RecentSearch(id=0, name=harry)]
    println(sortedWithList) // > [RecentSearch(id=0, name=harry), RecentSearch(id=1, name=car), RecentSearch(id=2, name=dog)]
}