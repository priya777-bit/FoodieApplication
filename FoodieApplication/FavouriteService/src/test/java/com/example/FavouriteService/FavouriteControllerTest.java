package com.example.FavouriteService;

import com.example.FavouriteService.controller.FavouriteController;
import com.example.FavouriteService.model.Favourite;
import com.example.FavouriteService.service.FavouriteServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class FavouriteControllerTest {

    @InjectMocks
    private FavouriteController favouriteController;

    @Mock
    private FavouriteServiceImpl favouriteService;

    private Favourite favourite,favourite1;

    private List<Favourite> favouriteList;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        favourite = new Favourite("f001","priya@gmail.com","curry leaves","naan");
        favourite1 = new Favourite("f002","priya@gmail.com","orange tree","biryani");
        favouriteList = Arrays.asList(favourite,favourite1);

        mockMvc = MockMvcBuilders.standaloneSetup(favouriteController).build();
    }

    @BeforeEach
    public void tearDown()
    {
        favourite=favourite1=null;
    }

    @Test
    public void givenFavouriteToAddReturnFavourite() throws Exception {
        when(favouriteService.addFavourite(favourite)).thenReturn(favourite);

        mockMvc.perform(post("/api/user/users/favourite/addFavourite")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(favourite)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());

        verify(favouriteService,times(1)).addFavourite(favourite);
    }

    @Test
    public void givenUserMailIdReturnFavouriteList() throws Exception {
        when(favouriteService.getALlFavourite(favourite.getUserMailId())).thenReturn(favouriteList);

        mockMvc.perform(get("/api/user/users/favourite/getFavourite/priya@gmail.com")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(favourite)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(favouriteService,times(1)).getALlFavourite(favourite.getUserMailId());
    }

    private static String jsonToString(final Object object) throws JsonProcessingException
    {
        String text = null;
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonText=objectMapper.writeValueAsString(object);
            text = jsonText;
        }
        catch (JsonProcessingException je)
        {
            text = "Caught Error During Conversion Of Format";
        }
        return text;

    }
}
