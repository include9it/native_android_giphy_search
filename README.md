## Main task:
Create an application to search for GIF images using Giphy API (https://developers.giphy.com/docs/api/endpoint#search).

### Requirements:
- Implement "live search" - i.e. request is sent in N milliseconds (for example 300) after the user has entered some input;
- Results are displayed in the list or grid of items;
- Request pagination - load enough items to populate the list and load more items every time the user scrolls to the end of the list (limit/offset);
- UI can be very simple but should be responsive, snappy, and implemented according to the platform guidelines;

###  Bonus points will be given for:
- Using modern Android development approaches and libraries such as Android MVVM, Coroutines, Flow, Hilt or any other jetpack compose modules;
- Loading more results "seamlessly" before the user reaches the last item in the list so (at least on a decent network connection) the scrolling is not interrupted by the next page load;
- Unit tests (we don't expect 100% coverage but rather see how do you approach unit testing)
