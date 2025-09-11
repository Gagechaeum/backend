package com.gagechaeum.backend.chat.util;

import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Slf4j
public class ChatUtil {
	public static Long getUserIdFromPrincipal(Principal principal) {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
		return (Long)token.getPrincipal();
	}
}
