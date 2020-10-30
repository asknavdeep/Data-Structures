class MinPriorityQueue(private val capacity:Int) {
    
    private var size = 0
    private val heap = IntArray(capacity+1)
    
    fun insert(key:Int){
        if(isFull()) return
        heap[size+1] = key
        var k = size +1
        while(k > 1) {
            if(heap[k] < heap[k/2]){
                val temp = heap[k]
                heap[k] = heap[k/2]
                heap[k/2] = temp
            }
            k = k/2
        }
        size++
    }
    
    fun isEmpty():Boolean = size == 0
    fun isFull():Boolean = size == capacity
    override fun toString():String {
        var valueString = ""
        for(i in 1 until heap.size) valueString += ("${heap[i]} ")
        return valueString
    }
}

fun main(){
    val queue = MinPriorityQueue(5)
    queue.insert(5)
    queue.insert(2)
    queue.insert(1)
    queue.insert(4)
    queue.insert(3)
    print(queue.toString())
}