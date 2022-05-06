package com.aiytl.randomnumbergenerator.interfaces

import com.aiytl.randomnumbergenerator.model.DataItems

interface OnItemClickListener {
    fun onItemClick(position : Int, item : DataItems)
}