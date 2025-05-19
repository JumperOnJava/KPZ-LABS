# MKR 1

## Patterns used in code

### 1. Template method

Refactored `LightTaggedNode` and `LightParentNode` to remove duplicated code using template method pattern. Methods `startOpeningTag(); classes(); finishOpeningTag(); innerHTML(); closingTag();` used to construct outerHTML and can be overridden to change functionality as demonstrated in `ImageNode` and `LightParentNode`

### 2. Iterator

Added `Iterator<T>` interface and its implementations: `DFSIterator` - Depth first search iteration over `LightNode` tree, `NodeFilterIterator` subclasses iterate over filter matching elements: `ClassIterator` - filtering by css classname, `TagIterator` - filtering by tag name

### 3. State

Added `IFrameNode` that allows to fetch other website data. State defines what content node has. IFrameNode has 3 possible states: `DownloadingState` - to show to user that content is downloading, `FetchedState` - to show content and `ErrorState` - that implement `State` interface and can modify `IFrameNode`'s state no new one. `State` interface extends LightNode interface adding `setContext(IFrameNode)` method and `reload()` to fetch new data/ reload in case of an error