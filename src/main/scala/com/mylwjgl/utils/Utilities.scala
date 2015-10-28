package com.mylwjgl.utils

import org.lwjgl.BufferUtils


object Utilities {

  def createFloatBuffer(data:Array[Float]) = {
    val buffer = BufferUtils.createFloatBuffer(data.length)
    buffer.put(data)
    buffer.flip()
    buffer
  }

  def createByteBuffer(data:Array[Byte]) = {
    val buffer = BufferUtils.createByteBuffer(data.length)
    buffer.put(data)
    buffer.flip()
    buffer
  }
}
