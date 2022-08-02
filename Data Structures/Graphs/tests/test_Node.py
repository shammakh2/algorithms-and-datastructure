import Node


# Create tests only for complex error prone implementations

def test_addEdge():
    """
    Test for Graph.addEdge method.
    """

    g = Node.Graph()

    assert g.addEdge("jeff", "claus") is True

    n1 = g._Graph__nodes
    claus = n1.get("claus")
    jeff = n1.get("jeff")

    assert jeff is not None and claus is not None
    assert len(jeff._Node__toNode) == 1 and len(claus._Node__toNode) == 1
    assert jeff._Node__toNode.get("claus") is claus
