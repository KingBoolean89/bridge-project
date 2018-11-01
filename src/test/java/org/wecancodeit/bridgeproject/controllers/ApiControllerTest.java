package org.wecancodeit.bridgeproject.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.bridgeproject.model.State;
import org.wecancodeit.bridgeproject.repositories.StateRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StateRepository stateRepo;
	
	@Mock
	State stateOne;

	@Test
	public void shouldBeOkWhenAccessingStates() throws Exception {
		mockMvc.perform(get("/api/states")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldBeOkWhenAccessingAState() throws Exception {
		when(stateRepo.findById(1L)).thenReturn(Optional.of(stateOne));
		mockMvc.perform(get("/api/states/1")).andExpect(status().isOk());
	}
	
}
