package com.mylwjgl.graphicEngine

import com.mylwjgl.utils.Utilities
import org.lwjgl.opengl.GL15._
import org.lwjgl.opengl.GL30._
import org.lwjgl.opengl.GL20._
import org.lwjgl.opengl.GL11._

class VertexArrayObject {
  val VERTEX_ATTRIB = 0
  val TCOORD_ATTRIB = 1

  def apply(vertices: Array[Float], indices: Array[Byte]) ={
    createArrayObject(vertices,indices)
  }

  def createArrayObject(vertices: Array[Float], indices: Array[Byte]) = {
    val vao = glGenVertexArrays()
    glBindVertexArray(vao)

    createVerticesBuffer(vertices)
    createIndicesBuffer(indices)

    glBindVertexArray(0)
  }

  private def createVerticesBuffer(vertices:Array[Float]) = {
    val vboId = glGenBuffers
    glBindBuffer(GL_ARRAY_BUFFER, vboId)
    glBufferData(GL_ARRAY_BUFFER, Utilities.createFloatBuffer(vertices), GL_STATIC_DRAW)
    glVertexAttribPointer(VERTEX_ATTRIB, 3, GL_FLOAT, false, 0, 0)
    glBindBuffer(GL_ARRAY_BUFFER, 0)
  }

  private def createIndicesBuffer(indices:Array[Byte]) = {
    val ibo = glGenBuffers
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo)
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utilities.createByteBuffer(indices), GL_STATIC_DRAW)
//    glVertexAttribPointer(VERTEX_ATTRIB, 3, GL_FLOAT, false, 0, 0)
//    glBindBuffer(GL_ARRAY_BUFFER, 0)
  }

}
