class LinkedList {
    data class Node (
        var data:Int,
        var next:Node? = null
    )
    
    var head : Node? = null
    
    fun addNode(value:Int){
        var root = head
        if(head == null){
            head = Node(value)
            return
        }
        while(root!!.next != null) root = root.next
        root.next = Node(value)
    }
    
    override fun toString():String{
        var valueString = "HEAD ->"
        var root = head
        while(root!=null){
            valueString+= "${root.data} ->"
            root = root.next
        }
        valueString += " END"
        return valueString
    }
}

fun main() {
    val ll = LinkedList()
    ll.addNode(1)
    ll.addNode(2)
    ll.addNode(3)
    ll.addNode(4)
    print(ll.toString())
}