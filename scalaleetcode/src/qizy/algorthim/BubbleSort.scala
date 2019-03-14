package qizy.algorthim

object BubbleSort {

  def bubblesort(a: Array[Int]) = {
    for(i<- 0 until a.length-1){
      for(j<- 0 until a.length-1-i){
        if(a(j)<=a(j+1)){
          val t =a(j)
          a(j)=a(j+1)
          a(j+1)=t
        }
      }
    }
  }


  def main(args:Array[String]) {
    val a = Array(4,1,6,2,8,9,11,3,5)
    bubblesort(a)
    for( i<- 0 until a.length){
      println(a(i))
    }
  }
}
