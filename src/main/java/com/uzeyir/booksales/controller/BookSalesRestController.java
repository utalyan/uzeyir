package com.uzeyir.booksales.controller;

import com.uzeyir.booksales.dto.UserDto;
import com.uzeyir.booksales.model.*;
import com.uzeyir.booksales.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/booksales")
public class BookSalesRestController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private OrdersServiceImpl ordersService;

    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * User oluştur.
     * @param userDto
     * @return
     */
    @PostMapping(path = "/user/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);

        User returnUser = userService.create(user);

        UserDto returnUserDto = modelMapper.map(returnUser,UserDto.class);

        return returnUserDto;
    }

    /**
     * User sil.
     * @param id
     */
    @PostMapping(path = "/user/delete/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public void deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
    }

    /**
     * id ile User bul
     * @param id
     * @return
     */
    @PostMapping(path = "/user/findById/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public UserDto findById(@PathVariable("id") Long id){
        return modelMapper.map(userService.findById(id),UserDto.class);
    }

    /**
     * tüm User bul.
     * @return
     */
    @PostMapping(path = "/user/allUser",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public List<UserDto> allUser(){
        List<UserDto> userDtos= userService.userList()
                .stream()
                .map(u->new UserDto(u.getId(),u.getName(),u.getAddress(),u.getMailAddress()))
                .collect(Collectors.toList());
        return userDtos;
    }

    /**
     * Category oluştur.
     * @param category
     * @return
     */
    @PostMapping(path = "/category/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Category createCategory(@RequestBody Category category) {
        return categoryService.create(category);
    }

    /**
     * Category sil.
     * @param id
     */
    @PostMapping(path = "/category/delete/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.delete(id);
    }

    /**
     * Tüm Category getir.
     * @return
     */
    @PostMapping(path = "/category/allCategory",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}

    )
    public List<Category> getAllCatogory(){
        return categoryService.categoryList();
    }

    /**
     * Book oluştur.
     * @param book
     * @return
     */
    @PostMapping(path = "/book/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Book createBook(@RequestBody Book book){
        return bookService.create(book);
    }

    @PostMapping(path = "/book/delete/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public void deleteBook(@PathVariable("id") Long id){
        bookService.delete(id);
    }

    @PostMapping(path = "/book/findById/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public Book findBookById(@PathVariable("id") Long id){
        return  bookService.findById(id);
    }

    @PostMapping(path = "/book/allBook",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public List<Book> allBook(){
        return bookService.bookList();
    }

    @PostMapping(path = "/orders/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public Orders ordersCreate(@RequestBody Orders orders){
        return ordersService.create(orders);
    }

    @PostMapping(path = "/orders/delete/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public void ordersDelete(@PathVariable("id") Long id){
        ordersService.delete(id);
    }

    @PostMapping(path = "/orders/findById/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public Orders ordersFindById(@PathVariable("id") Long id){
        return ordersService.findById(id);
    }


    @PostMapping(path = "/orderDetail/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public List<OrderDetail> orderDetailCreate(@RequestBody List<OrderDetail> orderDetails){
        return orderDetailService.create(orderDetails);
    }

    @PostMapping(path = "/orderDetail/findByOrderId/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public List<OrderDetail> findByOrderId(@PathVariable("id") Long id){
        return orderDetailService.findByOrdersId(id);
    }

    @PostMapping(path = "/orderDetail/deleteByOrderDetail/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public void deleteOrderDetail(@PathVariable("id") Long id){
        orderDetailService.delete(id);
    }

}
