# MKR 1

## Patterns used in code

### 1. Template method

Refactored `LightTaggedNode` and `LightParentNode` to remove duplicated code using template method pattern. Methods `startOpeningTag(); classes(); finishOpeningTag(); innerHTML(); closingTag();` used to construct outerHTML and can be overridden to change functionality as demonstrated in `ImageNode` and `LightParentNode`

### 2. Iterator

Added `Iterator<T>` interface and its implementations: `DFSIterator` - Depth first search iteration over `LightNode` tree, `NodeFilterIterator` subclasses iterate over filter matching elements: `ClassIterator` - filtering by css classname, `TagIterator` - filtering by tag name

