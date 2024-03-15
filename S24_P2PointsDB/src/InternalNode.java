
/**
 * This class represents and internal node in
 * the PRQuadTree. It contains no data other
 * than the pointers to its 4 children.
 */
public class InternalNode implements QuadNode {
    private LeafNode nw;
    private LeafNode ne;
    private LeafNode sw;
    private LeafNode se;

}
