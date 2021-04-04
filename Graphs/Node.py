class CorruptDataException(Exception):
    """
    Created a new exception which will be thrown on detection of corrupt data.
    """
    pass


class Node:
    """
    Nodes are units of a graph.
    """

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
    """
    Graph contains nodes. This undirected graph
    """

    def __init__(self):
        self.__nodes = {}

    def addNode(self, node):
        """
        Add nodes to __nodes dictionary
        """
        pass

    def addEdge(self, fromNode, toNode):
        """
        Add a relationship between two nodes. If the nodes don't exist. Make
        the nodes
        """

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
            raise CorruptDataException("Data corruption detected")

        return True

    def addEdgeStrict(self, fromNode, toNode):
        """
        Add a relationship between two nodes. This is strict so does not add a
        relationship if node doesn't exist.
        """

        nfrom = self.__nodes.get(fromNode)
        nto = self.__nodes.get(toNode)

        if (nfrom is None):
            print("'from' Node does not exist")
            return

        if (nto is None):
            print("'to' Node does not exist")
            return

        check1 = nfrom.addToNode(nto)
        check2 = nto.addToNode(nfrom)

        if (not check1 and not check2):
            return False
        elif (not check1 or not check2):
            raise CorruptDataException("Data corruption detected")

        return True

    def depthFirstSearch(self):
        """
        Implement depth first search algorithm that prints the nodes in order.
        Add optional start and end parameters.
        """
        pass

    def breadthFirstSearch(self):
        """
        Implement bredth first search algorithm that prints the nodes in order.
        Add optional start and end parameters.
        """
        pass


if __name__ == "__main__":
    x = Graph()
    x.addEdgeStrict("jeff", "chu")
    print(x._Graph__nodes)
    # print(x._Graph__nodes["jeff"]._Node__toNode)
    # print(x._Graph__nodes["chu"]._Node__toNode)
