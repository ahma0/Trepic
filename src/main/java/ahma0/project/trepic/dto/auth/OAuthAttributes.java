package ahma0.project.trepic.dto.auth;

import ahma0.project.trepic.domain.Member;
import ahma0.project.trepic.service.IdCheck;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey,
                           String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId,
                                     String memberNameAttributeName,
                                     Map<String, Object> attributes) {
        return ofGoogle(memberNameAttributeName, attributes);
    }

    public static OAuthAttributes ofGoogle(String memberNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name(String.valueOf(attributes.get("name")))
                .email(String.valueOf(attributes.get("email")))
                .picture(String.valueOf(attributes.get("picture")))
                .attributes(attributes)
                .nameAttributeKey(memberNameAttributeName)
                .build();
    }

    public Member toEntity() {
        return Member.builder()
                .idUsedByMember(IdCheck.generateRandomId())
                .email(email)
                .nickname(name)
                .profile(picture)
                .password(IdCheck.generateRandomId())
                .build();
    }
}
