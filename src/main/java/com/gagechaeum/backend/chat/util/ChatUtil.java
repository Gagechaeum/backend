package com.gagechaeum.backend.chat.util;

import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import java.security.Principal;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class ChatUtil {
	public static Long getUserIdFromPrincipal(Principal principal) {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
		CustomUserDetails userDetails = (CustomUserDetails) token.getPrincipal();
		return userDetails.getUserId();
	}
}
