
class Node:

    def __init__(self):
        self.id = None
        self.__toNode = {}

    def addToNode(self, node):
        if (self.__toNode.get(node.id) is None):
            self.__toNode[node.id] = node
            return True
        else:
            return False


class Graph:

    def __init__(self):
        self.__nodes = {}

    def addNode(self, node):
        pass

    def addEdge(self, fromNode, toNode):

        nfrom = self.__nodes.get(fromNode)
        nto = self.__nodes.get(toNode)

        if (nfrom is None):
            nfrom = Node()
            nfrom.id = fromNode
            self.__nodes[fromNode] = nfrom

        if (nto is None):
            nto = Node()
            nto.id = toNode
            self.__nodes[toNode] = nto

        check1 = nfrom.addToNode(nto)
        check2 = nto.addToNode(nfrom)

        if (not check1 and not check2):
            return False
        elif (not check1 or not check2):
            # raise CorruptDataException("Data corruption detected")
            return

        return True

    def addEdgeStrict(self, fromNode, toNode):
        pass

    def depthFirstSearch(self):
        pass

    def breadthFirstSearch(self):
        pass


if __name__ == "__main__":
    x = Graph()
    x.addEdge("jeff", "chu")
    print(x._Graph__nodes)
    print(x._Graph__nodes["jeff"]._Node__toNode)
    print(x._Graph__nodes["chu"]._Node__toNode)
