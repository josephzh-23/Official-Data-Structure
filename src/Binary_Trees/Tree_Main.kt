package Binary_Trees

fun main(){

    var tree = Tree()
    tree.insert(7)
    tree.insert(4)
    tree.insert(9)
    tree.insert(1)
    tree.insert(6)
    tree.insert(8)

    tree.traverseInOrder()
    println("height of the tree is ${tree.height()}")

    var tree2 = Tree()
    tree2.insert(7)
    tree2.insert(4)
    tree2.insert(5)
    tree2.insert(10)
   println(" Are the 2 trees equal? " +tree.equals(tree2))


    println("the max of tree is ${tree2.max()}")

    println("the size of tree is ${tree2.size()}")

    var list = tree.getNodesAtDistance(1)
    list.forEach {
        println(" the nodes are ${it.toString()}")
    }
}









